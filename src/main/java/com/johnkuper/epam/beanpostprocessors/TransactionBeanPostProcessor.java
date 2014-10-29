package com.johnkuper.epam.beanpostprocessors;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.johnkuper.epam.annotation.Transaction;

public class TransactionBeanPostProcessor implements BeanPostProcessor {

	private Map<String, Class<?>> map = new HashMap<String, Class<?>>();

	@Override
	public Object postProcessAfterInitialization(final Object o, String s)
			throws BeansException {
		Class<?> clazz = o.getClass();
		Class<?> originalClass = map.get(s);
		if (originalClass != null) {
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
	public Object postProcessBeforeInitialization(Object o, String s)
			throws BeansException {
		Class<?> originalClass = o.getClass();
		if (originalClass.isAnnotationPresent(Transaction.class)) {
			map.put(s, originalClass);
		}

		return o;
	}
}
