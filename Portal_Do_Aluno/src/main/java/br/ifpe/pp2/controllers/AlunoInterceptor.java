package br.ifpe.pp2.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//implements HandlerInterceptor
@SuppressWarnings("deprecation")
public class AlunoInterceptor extends HandlerInterceptorAdapter   {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
		if(request.getSession().getAttribute("alunoLogado") == null) {
			request.getRequestDispatcher("/acessoNegado").forward(request, response);
			return false;
		} else {
			return true;
		}
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}
}
//@Override
//public void addResourceHandlers(ResourceHandlerRegistry registry) {
//  registry.addResourceHandler("/admin/**").addResourceLocations("classpath:/static/");
//
//}
//@Override
//public void addResourceHandlers(ResourceHandlerRegistry registry) {
//  registry
//    .addResourceHandler("/admin/**")
//    .addResourceLocations("classpath:/static/");
//}
//if (request.getRequestURL().toString().endsWith(recurso)) {
//	return true;
//}
