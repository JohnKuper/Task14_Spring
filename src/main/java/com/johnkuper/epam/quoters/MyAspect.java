package com.johnkuper.epam.quoters;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
	@Before("execution(* com.johnkuper.epam.quoters..*.sayQuote(..))")
	public void beforeTalkMethods(JoinPoint jp) {
		String className = jp.getTarget().getClass().getSimpleName();
		String methodName = jp.getSignature().getName();
		String message = String.format("Before method: %s for class: %s",
				methodName, className);
		System.out.println(message);
	}

}
