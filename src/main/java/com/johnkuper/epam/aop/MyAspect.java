package com.johnkuper.epam.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

	@Pointcut("execution(* com.johnkuper.epam.aop.*.*(..))")
	public void afterReturning() {
	}

	@AfterReturning(pointcut = "afterReturning()", returning = "retVal")
	public void afterReturningTest(String retVal) {
		System.out.println("AfterReturning result: " + retVal);
	}

}
