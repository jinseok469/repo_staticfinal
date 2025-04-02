package com.staticfinal.common.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

//import com.mysql.cj.Constants;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CheckLoginSessionInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		관리자용
		if(request.getRequestURI().contains("Xdm")) {
			if (request.getSession().getAttribute("sessSeqXdm") != null) {
				// by pass
			} else {
				response.sendRedirect("/signinXdmForm");
		        return false;
			}
		} else {
//			by pass
		}
		
//		사용자용
		if(request.getRequestURI().contains("Usr")) {
			if (request.getSession().getAttribute("sessSeqUsr") != null) {
				// by pass
			} else {
				response.sendRedirect("/signinUsrForm");
				return false;
			}
		} else {
//			by pass
		}
		
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
}