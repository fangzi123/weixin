package com.micro.rent.biz.defaults.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * @Description 首页控制器
 * @author 
 * @date 
 * @version 1.0
 */
@Controller
public class DefaultController extends com.micro.rent.common.web.controller._BaseController {

	@RequestMapping("/index")
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mv = null;
		
		mv = createMAV("default");
		
		return mv;
	}
	
}
