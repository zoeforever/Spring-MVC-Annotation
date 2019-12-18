package com.vistek.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.vistek.bean.*;

@Configuration
@ComponentScan("com.vistek.bean")
public class MainConfigOfLifeCycle {

	@Bean(initMethod = "init",destroyMethod = "destroy")
	public Car car() {
		return new Car();
	}
	
	@Bean
	public Train train() {
		return new Train();
	}
	@Bean
	public Dog dog() {
		return new Dog();
	}
}
