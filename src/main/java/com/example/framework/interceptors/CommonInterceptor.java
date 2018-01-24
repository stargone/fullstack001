package com.example.framework.interceptors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.example.home.service.HomeService;

public class CommonInterceptor extends HandlerInterceptorAdapter {
	protected Log log = LogFactory.getLog(CommonInterceptor.class);

	@Resource(name = "homeService")
	private HomeService homeService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (log.isDebugEnabled()) {
			log.debug("========================================         START         ========================================");
			log.debug("Request URI \t\t:  " + request.getRequestURI());
			boolean bool = serverChk(request, response);
			if (!bool) {
				log.debug("========================================          END          ========================================");
				return false;
			}
		}
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(
					"========================================          END          ========================================");
		}
	}

	public boolean serverChk(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return true;
	}
}