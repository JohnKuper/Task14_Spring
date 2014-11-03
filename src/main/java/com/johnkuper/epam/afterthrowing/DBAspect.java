package com.johnkuper.epam.afterthrowing;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DBAspect {

	@Value("${emails}")
	private String[] emails;

	@Pointcut("execution(* com.johnkuper.epam.afterthrowing.ExceptionThrownerImpl.*(..))")
	public void afterThrowingExceptionPointcut() {
	}

	@AfterThrowing(pointcut = "afterThrowingExceptionPointcut()", throwing = "dbRunTimeException")
	public void afterThrowing(DatabaseRuntimeException dbRunTimeException) {
		for (String email : emails) {
			String message = String.format("Message = %s, was send to email = %s ",
					dbRunTimeException.getMessage(), email);
			System.out.println(message);

		}
	}
}
