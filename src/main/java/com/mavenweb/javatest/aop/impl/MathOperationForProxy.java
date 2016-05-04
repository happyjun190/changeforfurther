package com.mavenweb.javatest.aop.impl;

import com.mavenweb.javatest.aop.IMathOperation;

public class MathOperationForProxy implements IMathOperation {

	@Override
	public int add(int i, int j) {
		int result = i + j;
		return result;
	}

	@Override
	public int sub(int i, int j) {
		int result = i + j;
		return result;
	}

	@Override
	public int mul(int i, int j) {
		int result = i + j;
		return result;
	}

	@Override
	public int div(int i, int j) {
		int result = i + j;
		return result;
	} 
	
}