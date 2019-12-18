package com.vistek.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.vistek.aop.MathCalculator;
import com.vistek.config.MainConfigAOP;

public class Test_AOP {
	AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(MainConfigAOP.class);

	@Test
	public void test() {
		MathCalculator math = appContext.getBean(MathCalculator.class);
		int i = math.div(6, 0);
		System.out.println(i);
	}
	private void printBeans(AnnotationConfigApplicationContext appContext) {

		String[] names = appContext.getBeanDefinitionNames();
		for (String string : names) {
			System.out.println(string);
		}
	}	
}
