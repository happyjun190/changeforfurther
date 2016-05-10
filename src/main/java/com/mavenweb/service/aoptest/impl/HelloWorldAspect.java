package com.mavenweb.service.aoptest.impl;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HelloWorldAspect {
	
	// 前置通知
        //@Before("execution(public JsonResult com.mavenweb.service.caigou.impl.CaigouSolrService.getCaigouBySolr(Map<String, Object>")
	public void beforeAdvice() {
		System.out.println("===========before advice");
	}

	
	// 后置最终通知
	public void afterFinallyAdvice() {
		System.out.println("===========after finally advice");
	}
	
}
