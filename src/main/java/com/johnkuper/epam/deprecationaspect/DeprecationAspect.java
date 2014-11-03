package com.johnkuper.epam.deprecationaspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.johnkuper.epam.annotation.MyDeprecated;

@Aspect
@Component
public class DeprecationAspect {
	@Around("execution((@com.johnkuper.epam.annotation.MyDeprecated *) com.johnkuper.epam.deprecationaspect.*.*(..))")
	public Object replaceDeprecated(ProceedingJoinPoint pjp) throws Throwable {
		String methodName = pjp.getSignature().getName();
		System.out.println("Entering: " + methodName);
		try {
			Object retVal = pjp.proceed();
			MyDeprecated ann = retVal.getClass().getAnnotation(
					MyDeprecated.class);
			Object newRetVal = ann.newClass().newInstance();
			return newRetVal;
		} finally {
			System.out.println("Exiting: " + methodName);
		}
	}
}
