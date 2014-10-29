package com.johnkuper.epam.beanpostprocessors;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.johnkuper.epam.annotation.Benchmark;

public class BenchmarkBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(final Object o, String s)
			throws BeansException {
		Class<?> clazz = o.getClass();
		Method[] methods = clazz.getMethods();
		boolean benchmarkFound = false;
		for (Method method : methods) {
			if (method.isAnnotationPresent(Benchmark.class)) {
				benchmarkFound = true;
				break;
			}
		}

		if (benchmarkFound) {
			Object proxy = Proxy.newProxyInstance(clazz.getClassLoader(),
					clazz.getInterfaces(), new InvocationHandler() {

						@Override
						public Object invoke(Object proxy, Method method,
								Object[] args) throws Throwable {
							Method originalClassMethod = o.getClass()
									.getMethod(method.getName(),
											method.getParameterTypes());
							if (originalClassMethod
									.isAnnotationPresent(Benchmark.class)) {
								long before = System.nanoTime();
								Object retVal = method.invoke(o, args);
								long after = System.nanoTime();
								System.out.println(after - before);
								return retVal;
							} else {
								return method.invoke(o, args);
							}
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
		return o;
	}
}
