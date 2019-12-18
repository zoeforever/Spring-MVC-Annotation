package com.vistek.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Train implements InitializingBean,DisposableBean {

	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("train afterPropertiesSet...");
	}

	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("train destroy...");
	}

}
