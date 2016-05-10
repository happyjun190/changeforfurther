package com.mavenweb.service.aoptest.impl;

import java.util.Map;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class HelloWorldAspect {
	
	// 前置通知
        @Before("execution(* com.mavenweb.service.caigou.ICaigouSolrService.getCaigouBySolr(..))")
	public void beforeAdvice(JoinPoint joinPoint) {
            String methodName = joinPoint.getSignature().getName();
            Object[] args = joinPoint.getArgs();
            for(Object arg:args) {
                System.err.println(arg.toString());
            }
            
            System.out.println("start:the current method name was : " + methodName);
	}

	
	// 后置最终通知
        @AfterReturning("execution(* com.mavenweb.service.caigou.ICaigouSolrService.getCaigouBySolr(..))")
	public void afterFinallyAdvice(JoinPoint joinPoint) {
            String methodName = joinPoint.getSignature().getName();
            System.out.println("end:the current method name was : " + methodName);
	}
	
}
