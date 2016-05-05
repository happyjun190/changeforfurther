package com.mavenweb.javatest.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.mavenweb.javatest.aop.IMathOperation;

public class MathOperationAutoProxy {
	//需要代理的对象
	private IMathOperation target;
	
	public MathOperationAutoProxy(IMathOperation target) {
		this.target = target;
	}
	
	@SuppressWarnings("rawtypes")
	public IMathOperation getMathOperationLoggingProxy() {
		IMathOperation proxy = null;
		
		//代理对象有一个类加载器负责加载
		ClassLoader loader = target.getClass().getClassLoader();
		Class[] interfaces = new Class[]{IMathOperation.class};
		
		//当调用代理对象其中的方法时执行该代码
		InvocationHandler h = new InvocationHandler() {

			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("invoke......");
				return 0;
			}
			
		};
		proxy = (IMathOperation) Proxy.newProxyInstance(loader, interfaces, h);
		return proxy;
	}
	
}
