package com.vistek.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import com.vistek.bean.Person;

@Configuration
@ComponentScan(value="com.vistek",useDefaultFilters = false,includeFilters = {
//		@Filter(type=FilterType.ANNOTATION,classes= {				Controller.class		})
		@Filter(type=FilterType.CUSTOM,classes=MyTypeFilter.class)
})
public class MainConfig {

	@Bean
	public Person person() {
		return new Person("lisi",30);
	}
}
