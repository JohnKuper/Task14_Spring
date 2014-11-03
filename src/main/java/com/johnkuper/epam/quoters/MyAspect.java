package com.johnkuper.epam.quoters;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

	@Pointcut("execution(* com.johnkuper.epam.quoters..*.sayQuote(..))")
	public void pointcutForsayQuoteMethod() {
	}

	@Before("pointcutForsayQuoteMethod()")
	public void beforeSayQuoteMethods(JoinPoint jp) {
		String className = jp.getTarget().getClass().getSimpleName();
		String methodName = jp.getSignature().getName();
		String message = String.format("Method: %s for class: %s was started.",
				methodName, className);
		System.out.println(message);
	}

	@After("pointcutForsayQuoteMethod()")
	public void afterSayQuoteMethod(JoinPoint jp) {
		String className = jp.getTarget().getClass().getSimpleName();
		String methodName = jp.getSignature().getName();
		String message = String.format(
				"Method: %s for class: %s was successfully completed.",
				methodName, className);
		System.out.println(message);
	}

}
