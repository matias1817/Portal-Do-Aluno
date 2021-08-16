package br.ifpe.pp2.controllers;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AcessoConfig  implements WebMvcConfigurer{
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
			
		String pathPattern = "/**/*.css";
	
        registry.addInterceptor(new AlunoInterceptor())
		.addPathPatterns(new String[]{"/aluno", "/aluno/*"}).excludePathPatterns(pathPattern);
		registry.addInterceptor(new ProfessorInterceptor())
		.addPathPatterns(new String[]{"/professor", "/professor/*"}).excludePathPatterns("/**/*.png", "/**/*.css");
		registry.addInterceptor(new AdminInterceptor())
		.addPathPatterns(new String[]{"/admin", "/admin/*"}).excludePathPatterns("/**/*.png", "/**/*.css");
		

	}
	 
	
}
