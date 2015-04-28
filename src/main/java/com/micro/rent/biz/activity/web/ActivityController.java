/**
 * 营销活动
 */
package com.micro.rent.biz.activity.web;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.micro.rent.biz.activity.service.ActivityService;
import com.micro.rent.biz.enum_.ETradeStatus;
import com.micro.rent.biz.myrent.vo.AuthInfo;
import com.micro.rent.biz.personal.service.TradeService;
import com.micro.rent.biz.weixin.service.AuthService;
import com.micro.rent.biz.weixin.service.WeixinUserInfoService;
import com.micro.rent.biz.weixin.vo.WeixinUserInfo;
import com.micro.rent.common.comm.ConfigUtil;
import com.micro.rent.common.web.controller._BaseController;
import com.micro.rent.common.web.service.SmsService;
import com.micro.rent.common.web.service.impl.SmsServiceImpl;
import com.micro.rent.dbaccess.dao.activity.ActivityDao;
import com.micro.rent.dbaccess.dao.activity.ActivityOrderDao;
import com.micro.rent.dbaccess.entity.activity.Activity;
import com.micro.rent.dbaccess.entity.activity.ActivityOrder;
import com.micro.rent.dbaccess.entity.personal.Trade;
import com.octo.captcha.component.word.wordgenerator.RandomWordGenerator;
import com.octo.captcha.component.word.wordgenerator.WordGenerator;

/**
 * 营销活动控制器
 *
 * @author liqianxi
 * @date 2014/12/08
 */
@Controller
@RequestMapping("/rental/activity")
public class ActivityController extends _BaseController {

    private transient static final Logger log = LoggerFactory
            .getLogger(ActivityController.class);

    /**
     * 活动Session中保存KEY的前缀
     */
    private static final String ACTIVITY_SSESSION_KEY_PREFIX = "Activity_";

    /**
     * 十里河活动首页请求相对路径预约
     */
    private static final String REQUEST_ORDER_PATH = "/rental/activity/shilihe";
    /**
     * 十里河活动首页请求相对路径预订
     */
    private static final String REQUEST_RESERVE_PATH = "/rental/activity/shilihe_trade";

    /**
     * 活动ID：1（我的另一半在十里河）
     */
    private static final String ACTIVITY_ID_SHILIHE = "1";

    /**
     * 十里河渠道标识码
     */
    private static final String CHANNEL_CODE_SHILIHE = "YJSLH";

    /**
     * 十里河活动预订金总额（单位:人民币分）
     */
    private static final int SHILIHE_RESERVE_TOTAL_FEE = 20000;

    /**
     * 微信网页授权服务
     */
    @Autowired
    private AuthService authService;

    /**
     * 微信用户基本信息服务
     */
    @Autowired
    private WeixinUserInfoService weixinUserInfoService;

    /**
     * 短信发送服务
     */
    @Autowired
    private SmsService smsService;

    /**
     * 活动信息服务
     */
    @Autowired
    private ActivityService activityService;

    /**
     * 预订
     */
    @Autowired
    private TradeService tradeService;

    /**
     * 显示十里河营销活动页(预订用)
     *
     * @param request
     * @return 十里河营销活动页
     */
    @RequestMapping("shilihe_trade")
    public ModelAndView displayActivityShiliheReserve(
            HttpServletRequest request, ModelMap modelMap) {
        ModelAndView mv = createMAV("activity/1210shiliheReserve");
        // 请求中没有微信生成的"code"
        if (StringUtils.isEmpty(request.getParameter("code"))) {
            log.debug("Weixin code is empty");
            mv.addObject("moveTo",
                    getShiliheRedirectUrl(request, REQUEST_RESERVE_PATH));

        } else {
            String code = request.getParameter("code");
            log.debug("Weixin code is : " + code);
            // 取得用户微信ID
            AuthInfo authInfo = authService.baseAuth(code);
            String weixinId = "";
            String accessToken = "";
            if (authInfo != null) {
                // 设定微信ID
                weixinId = authInfo.getOpenid();
                // 设定accessToken
                accessToken = authInfo.getAccess_token();

                // 查看该用户的预订状态
                Trade condition = new Trade();
                condition.setChannelCode(CHANNEL_CODE_SHILIHE);
                condition.setWeixinId(weixinId);
                Trade tradeInfo = tradeService.selectTradeInfo(condition);
                if (tradeInfo == null
                        || ETradeStatus.CANCEL.getCode().equals(
                                tradeInfo.getStatus())) {
                    // 未预订或者已取消时，查询是否有预约
                    int activityId = NumberUtils.toInt(ACTIVITY_ID_SHILIHE);
                    // 取得预约信息
                    /*
                     * ActivityOrder orderInfo = activityService
                     * .getActivityOrderInfo(activityId, weixinId); if
                     * (orderInfo != null) { // 已预约且租房券未使用 // 租房券额度(价值500元人民币)
                     * mv.addObject("couponFee", 50000);
                     * mv.addObject("nickName", orderInfo.getNickName()); //
                     * 电话号码 mv.addObject("telephone", orderInfo.getTelephone());
                     * } else {
                     */
                    // 获取微信用户基本信息
                    WeixinUserInfo weixinUserInfo = weixinUserInfoService
                            .getWeixinUserInfo(weixinId, accessToken);
                    mv.addObject("nickName", weixinUserInfo == null ? ""
                            : weixinUserInfo.getNickname());
                    // }
                    // 总额度
                    mv.addObject("totalFee", SHILIHE_RESERVE_TOTAL_FEE);

                } else {
                    log.info("----------已经支付过了------" + tradeInfo.getStatus());
                    if ("1".equals(tradeInfo.getStatus())) {
                        ModelAndView payok = createMAV("pay/payConfirm");
                        payok.addObject("payFee", 20000);
                        return payok;
                    }
                    // 订单号
                    mv.addObject("tradeNo", tradeInfo.getTradeNo());
                    // 电话号码
                    mv.addObject("telephone", tradeInfo.getTelephone());
                    // 总额度
                    mv.addObject("totalFee", tradeInfo.getTotalFee());
                    // 租房券额度
                    mv.addObject("couponFee", tradeInfo.getCouponFee());
                    // 支付额度
                    mv.addObject("payFee", tradeInfo.getPayFee());
                    // 订单状态
                    mv.addObject("payStatus", tradeInfo.getStatus());

                    // 延迟更新活动获得租房券使用状态为“已使用”
                    // activityService.updateActivityOrderIsUse(
                    // NumberUtils.toInt(ACTIVITY_ID_SHILIHE), weixinId,
                    // ActivityOrderDao.IS_USE_YES);
                }

                // 设定微信ID
                mv.addObject("weixinId", weixinId);
                // 设定access_token
                mv.addObject("accessToken", accessToken);
                // 设定渠道标识
                mv.addObject("channelCode", CHANNEL_CODE_SHILIHE);

                if (StringUtils.isEmpty(weixinId)) {
                    mv.addObject("gender", "girl");
                } else {
                    int weixinIdLastCha = Character.getNumericValue(weixinId
                            .charAt(weixinId.length() - 1));
                    mv.addObject("gender",
                            (weixinIdLastCha & 0x0001) == 0 ? "man" : "girl");
                }

            } else {
                // code无效时、重新申请授权
                log.debug("Weixin code is invalid");
                mv.addObject("moveTo",
                        getShiliheRedirectUrl(request, REQUEST_RESERVE_PATH));
            }
        }

        return mv;
    }

    /**
     * 预订/退订
     */
    @RequestMapping("shilihe_reserve")
    public ModelAndView reserveActivity(HttpServletRequest request,
            ModelMap modelMap) {
        ModelAndView mv = createMAV("activity/1210shiliheReserve");
        String action = "";
        boolean status = true;
        String message = "";
        // 订单号
        String tradeNo = findStringParameterValue(request, "tradeNo");
        if (StringUtils.isNotEmpty(tradeNo)) {
            // 订单状态
            String payStatus = findStringParameterValue(request, "payStatus");
            if (ETradeStatus.PAY.getCode().equals(payStatus)) {
                // 已支付状态时，做退款处理
                action = "refund";
                status = true;

                String weixinId = findStringParameterValue(request, "weixinId");
                // 更新活动获得租房券使用状态为“未使用”
                activityService.updateActivityOrderIsUse(
                        NumberUtils.toInt(ACTIVITY_ID_SHILIHE), weixinId,
                        ActivityOrderDao.IS_USE_NO);
            } else {
                // 未支付状态时，做支付处理
                action = "pay";
                status = true;
            }
        } else {
            // 租房券
            String couponFee = findStringParameterValue(request, "couponFee");
            if (StringUtils.isNotEmpty(couponFee)) {
                // 已预约状态时，做支付处理
                action = "pay";
                status = true;
            } else {
                // 未预约，检查验证码并做支付处理
                String verifyCode = findStringParameterValue(request,
                        "verifyCode");
                String orderTel = findStringParameterValue(request, "orderTel");
                String sessionKey = ACTIVITY_SSESSION_KEY_PREFIX
                        + ACTIVITY_ID_SHILIHE + "_" + orderTel;
                if (StringUtils.equals(verifyCode, (String) request
                        .getSession().getAttribute(sessionKey))) {
                    action = "pay";
                    status = true;
                    // 清空session中该预约信息
                    request.getSession().removeAttribute(sessionKey);
                } else {
                    status = false;
                    message = "输入的验证码有误，请重新输入！";
                }
            }
        }

        modelMap.put("action", action);
        modelMap.put("success", status);
        modelMap.put("message", message);
        return mv;
    }

    /**
     * 显示十里河营销活动页(预约用)
     *
     * @param request
     * @return 十里河营销活动页
     */
    @RequestMapping("shilihe")
    public ModelAndView displayActivityShiliheIndex(HttpServletRequest request,
            ModelMap modelMap) {
        ModelAndView mv = createMAV("activity/1210shilihe");
        // 请求中没有微信生成的"code"
        if (StringUtils.isEmpty(request.getParameter("code"))) {
            log.debug("Weixin code is empty");
            mv.addObject("moveTo",
                    getShiliheRedirectUrl(request, REQUEST_ORDER_PATH));

        } else {
            String code = request.getParameter("code");
            log.debug("Weixin code is : " + code);
            // 取得用户微信ID
            AuthInfo authInfo = authService.baseAuth(code);
            String weixinId = "";
            String accessToken = "";
            if (authInfo != null) {
                // 设定微信ID
                weixinId = authInfo.getOpenid();
                // 设定accessToken
                accessToken = authInfo.getAccess_token();

                // 取得活动进行状态
                int activityId = findIntegerParameterValue(request,
                        "activityId");
                int activityState = getActivityState(activityId);
                if (activityState == ActivityDao.ACTIVITY_STATE_ON_GOING) {
                    // 设定是否已经预约标志
                    mv.addObject("ordered", hasOrdered(activityId, weixinId));
                    log.debug("activityId:" + activityId + " weixinId:"
                            + weixinId);
                } else if (activityState == ActivityDao.ACTIVITY_STATE_END) {
                    // 设定是否活动已标志
                    mv.addObject("end", true);
                }

                // 设定微信ID
                mv.addObject("weixinId", weixinId);
                // 设定活动有效标志
                mv.addObject("activityValid", activityState);
                // 设定access_token
                mv.addObject("accessToken", accessToken);
                // 设定选择的性别

                if (StringUtils.isEmpty(weixinId)) {
                    mv.addObject("gender", "girl");
                } else {
                    int weixinIdLastCha = Character.getNumericValue(weixinId
                            .charAt(weixinId.length() - 1));
                    mv.addObject("gender",
                            (weixinIdLastCha & 0x0001) == 0 ? "man" : "girl");
                }
            } else {
                // code无效时、重新申请授权
                log.debug("Weixin code is invalid");
                mv.addObject("moveTo",
                        getShiliheRedirectUrl(request, REQUEST_ORDER_PATH));
            }
        }

        return mv;
    }

    /**
     * 获取预约验证码
     *
     * @param request
     */
    @RequestMapping("getVerifyCode")
    public void getVerifyCode(HttpServletRequest request, ModelMap modelMap) {
        // 预约电话号码
        String orderTel = this.findStringParameterValue(request, "orderTel");
        // 活动ID
        int activityId = NumberUtils.toInt(ACTIVITY_ID_SHILIHE);
        ;
        if (orderTel == null || orderTel == ""
                || !NumberUtils.isDigits(orderTel)) {
            modelMap.put("success", false);
            modelMap.put("message", "请输入正确的手机号！");
        } else {
            // 生成短信验证码
            try {
                WordGenerator wordGenerator = new RandomWordGenerator(
                        ConfigUtil.getConfig("verifycode.acceptchars"));
                String verifyCode = wordGenerator.getWord(4,
                        Locale.getDefault());
                // 将生成的短信验证码保存进Session
                request.getSession().setAttribute(
                        ACTIVITY_SSESSION_KEY_PREFIX + activityId + "_"
                                + orderTel, verifyCode);

                // 调用短信平台接口发送验证码
                if (sendVerifyCodeMessage(orderTel, verifyCode)) {
                    modelMap.put("success", true);
                    modelMap.put("verifyCode", verifyCode);
                } else {
                    modelMap.put("success", false);
                    modelMap.put("message", "验证码取得失败，请重新获取！");
                }
            } catch (Exception e) {
                logger.error("验证码备选字符读取失败！", e);
                modelMap.put("success", false);
                modelMap.put("message", "验证码取得失败，请重新获取！");
            }
        }
    }

    /**
     * 预约活动
     */
    @RequestMapping("order")
    public void orderActivity(HttpServletRequest request, ModelMap modelMap) {
        String orderTel = findStringParameterValue(request, "orderTel");
        String verifyCode = findStringParameterValue(request, "verifyCode");
        String weixinId = findStringParameterValue(request, "weixinId");
        String activityIdStr = findStringParameterValue(request, "activityId");
        String accessToken = findStringParameterValue(request, "accessToken");

        String sessionKey = ACTIVITY_SSESSION_KEY_PREFIX + activityIdStr + "_"
                + orderTel;
        int activityId = StringUtils.isBlank(activityIdStr) ? 0 : Integer
                .valueOf(activityIdStr);
        if (request.getParameterMap().containsKey("verifyCode")) {
            // 验证用户输入的验证码
            if (StringUtils.equals(verifyCode, (String) request.getSession()
                    .getAttribute(sessionKey))) {
                // 增加用户预约活动记录
                addActivityOrder(weixinId, orderTel, activityId, accessToken);
                // 清空session中该预约信息
                request.getSession().removeAttribute(sessionKey);

                modelMap.put("success", true);
            } else {
                modelMap.put("success", false);
                modelMap.put("message", "输入的验证码有误，请重新输入！");
            }

        } else {
            // 增加用户预约活动记录
            addActivityOrder(weixinId, orderTel, activityId, accessToken);
            modelMap.put("success", true);
        }

    }

    /**
     * 取得活动进行状态
     *
     * @param activityId
     *            活动ID
     * @return 1:进行中/0:未开始/-1:已结束
     */
    private int getActivityState(int activityId) {
        Activity activity = activityService.getActivityInfo(activityId);
        if (activity != null) {
            long activeStartTime = activity.getStartTime();
            long activeEndTime = activity.getEndTime();
            long currentTime = System.currentTimeMillis() / 1000;
            if (currentTime < activeStartTime) {
                return ActivityDao.ACTIVITY_STATE_NOT_BEGIN;
            } else if (currentTime <= activeEndTime) {
                return ActivityDao.ACTIVITY_STATE_ON_GOING;
            }
        }

        return ActivityDao.ACTIVITY_STATE_END;
    }

    /**
     * 用户是否已预约
     *
     * @param activityId
     *            活动ID
     * @param weixinId
     *            微信ID
     * @return true:已预约/false:未预约
     */
    private boolean hasOrdered(int activityId, String weixinId) {
        // 检索活动预约记录表
        ActivityOrder activityOrder = activityService.getActivityOrderInfo(
                activityId, weixinId);
        return activityOrder != null;
    }

    /**
     * 增加活动预约记录
     *
     * @param weixinId
     *            微信ID
     * @param orderTel
     *            预约电话
     * @param activityId
     *            活动ID
     * @param accessToken
     *            access_token
     */
    private void addActivityOrder(String weixinId, String orderTel,
            int activityId, String accessToken) {
        // 获取微信用户基本信息
        WeixinUserInfo weixinUserInfo = weixinUserInfoService
                .getWeixinUserInfo(weixinId, accessToken);
        ActivityOrder activityOrder = new ActivityOrder();
        activityOrder.setActivityId(activityId);
        activityOrder.setWeixinId(weixinId);
        activityOrder.setTelephone(orderTel);
        if (weixinUserInfo != null) {
            // 用户昵称
            activityOrder.setNickName(weixinUserInfo.getNickname());
            // 用户性别
            activityOrder.setGender(weixinUserInfo.getSex());
            // 用户头像
            activityOrder.setHeadImgUrl(weixinUserInfo.getHeadimgurl());
        }
        activityService.addActivityOrder(activityOrder);
    }

    /**
     * 发送预约短信
     *
     * @param tel
     *            预约者电话
     * @param verifyCode
     *            短信验证码
     * @return true:发送成功/fasle:发送失败
     */
    private boolean sendVerifyCodeMessage(String tel, String verifyCode) {
        boolean flag = false;
        try {
            String templateId = ConfigUtil
                    .getConfig("cloopen.orderVerifyCodeTemplate");
            Map<String, Object> result = smsService.sendTemplateSMS(templateId,
                    tel, new String[] { verifyCode, "1" });

            if (SmsServiceImpl.SUCCESS_CODE.equals(result.get("statusCode"))) {
                flag = true;
            } else {
                // 异常返回输出错误码和错误信息
                log.error("向用户：" + tel + "发送短信失败：[code:"
                        + result.get("statusCode") + ", message:"
                        + result.get("statusMsg") + "]");
            }

        } catch (Exception e) {
            log.error("验证码短信模板ID取得失败！", e);
        }

        return flag;
    }

    /**
     * 编辑十里河活动微信重定向URL
     *
     * @param request
     * @return 编辑后的URL
     */
    private String getShiliheRedirectUrl(HttpServletRequest request,
            String pathType) {
        String url = "";
        try {
            String redirectURI = ConfigUtil.getConfig("balancer.server.url")
                    + request.getContextPath() + pathType + "?activityId="
                    + ACTIVITY_ID_SHILIHE;
            url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="
                    + ConfigUtil.getConfig("appid")
                    + "&redirect_uri="
                    + redirectURI
                    + "&response_type=code&scope=snsapi_userinfo&state=shilihe#wechat_redirect";
        } catch (Exception e) {
            log.error("取配置信息失败![appid或者balancer.server.url]");
        }

        return url;
    }
}
