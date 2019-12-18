package com.vistek;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.vistek.config.AppConfig;
import com.vistek.config.RootConfig;

public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer  {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[] {RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[] {AppConfig.class};
	}

	/**
	 * 获取servlet 映射信息
     * / : 拦截所有资源  但不包括  *.jsp
     * /* : 拦截所有资源  包括  *.jsp
     * <p>
     * jsp 页面是tomcat的jsp引擎解析的
     *
     * @return
     */

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}

}
