package com.mavenweb.service.aoptest.impl;

import org.springframework.stereotype.Service;

import com.mavenweb.service.aoptest.ITestSpringAop;

@Service
public class TestSpringAop implements ITestSpringAop {

	@Override
	public void sayHello() {
		System.out.println("============Hello World!");
	}

}
