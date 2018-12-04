package com.guys.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

public class GuysHandlerExceptionResolver extends SimpleMappingExceptionResolver {
	protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object o,
			Exception e) {
		request.setAttribute("ex", e);
		e.printStackTrace();
		return super.doResolveException(request, response, o, e);
	}
}
