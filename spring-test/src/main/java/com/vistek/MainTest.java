package com.vistek;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vistek.bean.Person;
import com.vistek.config.MainConfig;

public class MainTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
		Person person = applicationContext.getBean(Person.class);
		System.out.println(person);
		
		String[] beans = applicationContext.getBeanNamesForType(Person.class);
		for (String bean : beans) {
			System.out.println(bean);
		}
		
		String[] names = applicationContext.getBeanDefinitionNames();
		for (String string : names) {
			System.out.println(string);
		}
	}
	
}
