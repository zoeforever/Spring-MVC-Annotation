package com.vistek.servlet;

import java.util.EnumSet;
import java.util.Set;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import javax.servlet.annotation.HandlesTypes;

import com.vistek.service.HelloService;

@HandlesTypes(value = { HelloService.class })
public class MyServletContainerInitializer implements ServletContainerInitializer {

	@Override
	public void onStartup(Set<Class<?>> arg0, ServletContext sc) throws ServletException {
		// TODO Auto-generated method stub
		for (Class<?> class1 : arg0) {
			System.out.println(class1);
		}
		Dynamic servlet = sc.addServlet("userServlet", new UserServlet());
		servlet.addMapping("/user");
		
		sc.addListener(UserListener.class);
		
	    FilterRegistration.Dynamic filter = sc.addFilter("userFilter", new UserFilter());
	    filter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
	}
}
