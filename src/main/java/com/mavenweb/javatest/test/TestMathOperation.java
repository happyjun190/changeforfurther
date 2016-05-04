package com.mavenweb.javatest.test;

import com.mavenweb.javatest.aop.IMathOperation;
import com.mavenweb.javatest.aop.impl.MathOperation;

public class TestMathOperation {
	public static void main(String args[]) {
		IMathOperation mathOperation = null;
		mathOperation = new MathOperation();
		mathOperation.add(1, 3);
		mathOperation.sub(5, 1);
		mathOperation.mul(3, 4);
		mathOperation.div(4, 2);
	}
}