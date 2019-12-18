package com.vistek.bean;

import org.springframework.beans.factory.FactoryBean;

public class ColorFactoryBean implements FactoryBean<Color> {

	public Color getObject() throws Exception {
		// TODO Auto-generated method stub
		return new Color();
	}

	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return Color.class;
	}
}
