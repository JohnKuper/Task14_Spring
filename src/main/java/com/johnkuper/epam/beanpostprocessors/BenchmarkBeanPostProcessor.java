package com.johnkuper.epam.beanpostprocessors;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import com.johnkuper.epam.annotation.Benchmark;

@Component
public class BenchmarkBeanPostProcessor implements BeanPostProcessor {

	@Autowired
	private ConfigurableListableBeanFactory factory;

	@Override
	public Object postProcessAfterInitialization(final Object o, String s)
			throws BeansException {
		BeanDefinition beanDefinition = factory.getBeanDefinition(s);
		String beanClassName = beanDefinition.getBeanClassName();
		Class<?> originalClass = null;
		try {
			originalClass = Class.forName(beanClassName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Method[] methods = originalClass.getMethods();
		boolean benchmarkFound = false;
		for (Method method : methods) {
			if (method.isAnnotationPresent(Benchmark.class)) {
				benchmarkFound = true;
				break;
			}
		}

		if (benchmarkFound) {
			final Class<?> finalOriginalClass = originalClass;
			Object proxy = Proxy.newProxyInstance(
					originalClass.getClassLoader(),
					originalClass.getInterfaces(), new InvocationHandler() {

						@Override
						public Object invoke(Object proxy, Method method,
								Object[] args) throws Throwable {
							Method originalClassMethod = finalOriginalClass
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
