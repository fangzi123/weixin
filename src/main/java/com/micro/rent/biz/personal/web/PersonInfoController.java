package com.micro.rent.biz.personal.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.micro.rent.biz.activity.service.ActivityService;
import com.micro.rent.biz.personal.service.FavoritesService;
import com.micro.rent.biz.personal.vo.HouseVo;
import com.micro.rent.biz.weixin.service.AuthService;
import com.micro.rent.common.support.SessionUtil;
import com.micro.rent.common.web.controller._BaseController;
import com.micro.rent.dbaccess.dao.activity.ActivityDao;
import com.micro.rent.dbaccess.entity.activity.UserActivity;


@Controller
@RequestMapping("/rental/person")
public class PersonInfoController extends _BaseController {

	// “赏”活动的活动ID
	private static final int ACTIVITY_SHANG_ID = 2;

	@Autowired
	private FavoritesService favoritesService;
	@Autowired
	private AuthService authService;
	@Autowired
	private ActivityService activityService;

	@RequestMapping("/queryPerson")
	public ModelAndView queryFavoritesList(HttpServletRequest request,
			@RequestParam(value = "code", required = false) String code) {
		ModelAndView mv = createMAV("personal/person_info");
		return mv;
	}

	@RequestMapping("/info")
	public ModelAndView queryInfo(HttpServletRequest request,
			@RequestParam(value = "code", required = false) String code) {
		ModelAndView mv = createMAV("personal/personal");

		String openid = SessionUtil.getOpenId(request, authService);
		log.info("openid[{}]", new Object[] { openid });

		// 默认显示用户当前位置所在的城市
//		MapPoint mapPoint = (MapPoint) LocationEventMessageHandler.lrumap
//				.get(openid);
//		mapPoint=new MapPoint("116.5","39.9");
//		openid="o00MJj9TY-UZSyqVfC5cZ5yy882E";
//		LocationEventMessageHandler.lrumap.put(openid, mapPoint);
//		request.getSession().setAttribute("openId", openid);
//		if (mapPoint == null) {
//			// throw new BizException("请检查定位设置是否打开");
//			// 返回提示页面，提示用户打开位置定位
//			mv = createMAV("myrent/note");
//			return mv;
//		}
		
		log.debug("weixinId is " + openid);

		List<HouseVo> resultList = favoritesService.queryCollectList(openid);
		mv.addObject("resultList", resultList);
		mv.addObject("weixinId", openid);
		mv.addObject("type","f");

		return mv;
	}

	/**
	 * 取得用户参与活动列表信息
	 * 
	 * @param request
	 * @return ModeAndView
	 */
	@RequestMapping("/activity")
	public ModelAndView queryActivityInfo(HttpServletRequest request) {
		ModelAndView mv = createMAV("personal/activity_list");
		String weixinId = SessionUtil.getOpenId(request, authService);
		log.debug("activity_list weixinId:", weixinId);
		List<UserActivity> resultList =
				activityService.getActivityInfoListByWeixinId(weixinId);
		editActivityResultList(resultList);
		mv.addObject("resultList", resultList);

		return mv;
	}

	/**
	 * 编辑活动结果列表信息
	 * @param resultList
	 */
	private void editActivityResultList(List<UserActivity> resultList) {
		if (resultList != null && resultList.size() > 0) {
			long currentTime = System.currentTimeMillis() / 1000;
			for (UserActivity userActivity : resultList) {
				// 设定活动状态
				long activityStartTime = userActivity.getStartTime();
				long activityEndTime = userActivity.getEndTime();
				if (currentTime < activityStartTime || activityEndTime < currentTime) {
					userActivity.setActivityStatus(ActivityDao.ACTIVITY_STATE_END);
				} else {
					userActivity.setActivityStatus(ActivityDao.ACTIVITY_STATE_ON_GOING);
				}
				// 
				if (userActivity.getActivityId() == ACTIVITY_SHANG_ID) {
					userActivity.setActivityUrl(userActivity.getActivityUrl()
							+ "?source=weixin&weixin_id=" + userActivity.getWeixinId());
				}
			}
		}
	}
}
