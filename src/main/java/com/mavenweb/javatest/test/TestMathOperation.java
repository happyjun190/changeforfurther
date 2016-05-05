package com.mavenweb.javatest.test;

import com.mavenweb.javatest.aop.IMathOperation;
import com.mavenweb.javatest.aop.impl.MathOperationImpl;

public class TestMathOperation {
	public static void main(String args[]) {
		IMathOperation target = new MathOperationImpl();
		target = new MathOperationAutoProxy(target).getMathOperationLoggingProxy();
		
		/*mathOperation.add(1, 3);
		mathOperation.sub(5, 1);
		mathOperation.mul(3, 4);
		mathOperation.div(4, 2);
		*/
		int result = target.add(3, 5);
		
		System.out.println(result);
	}
}