package com.vistek.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import com.vistek.bean.Color;
import com.vistek.bean.ColorFactoryBean;
import com.vistek.bean.Person;
import com.vistek.bean.Red;
import com.vistek.conditional.LinuxConditional;
import com.vistek.conditional.MyImportBeanDefinitionRegistrar;
import com.vistek.conditional.MyImportSelector;
import com.vistek.conditional.WindowsConditional;

@Configuration
@Import({Color.class,Red.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})
public class MainConfig2 {

	@Bean("Linux")
	@Conditional({LinuxConditional.class})
	public Person person() {
		return new Person("Linux",25);
	}
	@Conditional({WindowsConditional.class})
	@Bean("Windows")
	public Person person02() {
		return new Person("Windows",36);
	}
	
	@Bean
	public ColorFactoryBean colorFactoryBean() {
		return new ColorFactoryBean();
	}
}
