package com.johnkuper.epam.beanpostprocessors;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.johnkuper.epam.annotation.Transaction;

public class TransactionBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(final Object o, String arg1)
			throws BeansException {
		Class<?> clazz = o.getClass();
		if (clazz.isAnnotationPresent(Transaction.class)) {
			Object proxy = Proxy.newProxyInstance(clazz.getClassLoader(),
					clazz.getInterfaces(), new InvocationHandler() {

						@Override
						public Object invoke(Object proxy, Method method,
								Object[] args) throws Throwable {
							System.out.println("Transaction was started");
							Object retVal = method.invoke(o, args);
							System.out.println("Transaction was closed");
							return retVal;
						}
					});
			return proxy;
		} else {
			return o;
		}

	}

	@Override
	public Object postProcessBeforeInitialization(Object o, String arg1)
			throws BeansException {

		return o;
	}

}
