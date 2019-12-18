package com.vistek.conditional;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import com.vistek.bean.Rainbow;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		boolean red = registry.containsBeanDefinition("com.vistek.bean.Red");
		boolean blue = registry.containsBeanDefinition("com.vistek.bean.Blue");
		if(red && blue) {			
			registry.registerBeanDefinition("rainbow", new RootBeanDefinition(Rainbow.class));
		}
	}

}
