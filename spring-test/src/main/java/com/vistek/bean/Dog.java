package com.vistek.bean;

import org.springframework.stereotype.Component;
import java.lang.annotation.*;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Component
public class Dog {
public Dog() {
	System.out.println("dog...");
}
@PostConstruct
public void init() {
	System.out.println("dog init...");
}
@PreDestroy
public void destory() {
	System.out.println("dog destory...");
}
}

