package com.mavenweb.javatest.aop.impl;

import com.mavenweb.javatest.aop.IMathOperation;

public class MathOperation implements IMathOperation {

	@Override
	public int add(int i, int j) {
		System.out.println(" the method add input params is "+i+","+j);
		int result = i + j;
		System.out.println(" the method add output result is "+result);
		return result;
	}

	@Override
	public int sub(int i, int j) {
		System.out.println(" the method sub input params is "+i+","+j);
		int result = i + j;
		System.out.println(" the method sub output result is "+result);
		return result;
	}

	@Override
	public int mul(int i, int j) {
		System.out.println(" the method mul input params is "+i+","+j);
		int result = i + j;
		System.out.println(" the method mul output result is "+result);
		return result;
	}

	@Override
	public int div(int i, int j) {
		System.out.println(" the method div input params is "+i+","+j);
		int result = i + j;
		System.out.println(" the method div output result is "+result);
		return result;
	} 
	
}