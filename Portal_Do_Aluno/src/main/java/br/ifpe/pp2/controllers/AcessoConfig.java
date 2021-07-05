package br.ifpe.pp2.controllers;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AcessoConfig  implements WebMvcConfigurer{
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AlunoInterceptor())
		.addPathPatterns(new String[]{"/aluno", "/aluno/*"});
		registry.addInterceptor(new ProfessorInterceptor())
		.addPathPatterns(new String[]{"/professor", "/professor/*"});
		registry.addInterceptor(new AdminInterceptor())
		.addPathPatterns(new String[]{"/admin", "/admin/*"});
	}
	
}
