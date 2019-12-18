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
	 * ��ȡservlet ӳ����Ϣ
     * / : ����������Դ  ��������  *.jsp
     * /* : ����������Դ  ����  *.jsp
     * <p>
     * jsp ҳ����tomcat��jsp���������
     *
     * @return
     */

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}

}
