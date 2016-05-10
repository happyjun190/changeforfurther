package com.mavenweb.javatest.aop.impl;

import com.mavenweb.javatest.aop.IMathOperation;

public class TestMathOperation {
	public static void main(String args[]) {
		IMathOperation target = new MathOperationImpl();
		target = new MathOperationAutoProxy(target).getMathOperationLoggingProxy();
		
		/*mathOperation.add(1, 3);
		mathOperation.sub(5, 1);
		mathOperation.mul(3, 4);
		mathOperation.div(4, 2);
		*/
		target.add(3, 5);
		target.mul(5, 9);
                
		//System.out.println(result);
	}
}