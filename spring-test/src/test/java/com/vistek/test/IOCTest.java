package com.vistek.test;

import java.util.Map;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import com.vistek.bean.Person;
import com.vistek.config.MainConfig;
import com.vistek.config.MainConfig2;

public class IOCTest {
	AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(MainConfig2.class);

	@Test
	public void test04() {
		printBeans(appContext);
        Object bean = appContext.getBean("colorFactoryBean");
        System.out.println(bean.getClass());
        // 通过 & 前缀 获取工厂bean本身的对象
        Object bean3 = appContext.getBean("&colorFactoryBean");
        System.out.println(bean3.getClass());

	}
	
	@SuppressWarnings("resource")
	@Test
	public void test03() {

		printBeans(appContext);
	    Environment environment = appContext.getEnvironment();
	    String osName = environment.getProperty("os.name");

	    System.out.println(osName);

		Map<String, Person> persons =  appContext.getBeansOfType(Person.class);
	
		System.out.println(persons);

//		Object bean = appContext.getBean("person");
//		Object bean2 = appContext.getBean("person");
//		System.out.println(bean==bean2);
	}
	
	private void printBeans(AnnotationConfigApplicationContext appContext) {

		String[] names = appContext.getBeanDefinitionNames();
		for (String string : names) {
			System.out.println(string);
		}
	}
	
	@SuppressWarnings("resource")
	@Test
	public void test02() {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(MainConfig2.class);

		String[] names = appContext.getBeanDefinitionNames();
		for (String string : names) {
			System.out.println(string);
		}
		Object bean = appContext.getBean("person");
//		Object bean2 = appContext.getBean("person");
//		System.out.println(bean==bean2);
	}
	
	@SuppressWarnings("resource")
	@Test
	public void test01() {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(MainConfig.class);

		String[] names = appContext.getBeanDefinitionNames();
		for (String string : names) {
			System.out.println(string);
		}
	}
}
