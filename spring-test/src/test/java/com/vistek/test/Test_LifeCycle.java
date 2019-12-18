package com.vistek.test;

import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.vistek.config.MainConfigOfLifeCycle;

public class Test_LifeCycle {
	AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);

	@Test
	public void test() {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
		printBeans(appContext);
		List<BeanFactoryPostProcessor> ss =	appContext.getBeanFactoryPostProcessors();
		for (BeanFactoryPostProcessor beanFactoryPostProcessor : ss) {
			System.out.println(beanFactoryPostProcessor);
		}
		appContext.close();
	}
	private void printBeans(AnnotationConfigApplicationContext appContext) {

		String[] names = appContext.getBeanDefinitionNames();
		for (String string : names) {
			System.out.println(string);
		}
	}
	
}
