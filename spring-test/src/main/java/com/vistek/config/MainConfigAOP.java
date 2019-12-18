package com.vistek.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import com.vistek.aop.LogAspects;
import com.vistek.aop.MathCalculator;

@Configuration
@EnableAspectJAutoProxy
public class MainConfigAOP {

	@Bean
	public MathCalculator mathCalculator() {
		return new MathCalculator();
	}
	
	@Bean
	public LogAspects logAspect() {
		return new LogAspects();
	}
}
