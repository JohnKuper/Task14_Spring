package com.johnkuper.epam.deprecationaspect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationListener implements
		ApplicationListener<ContextRefreshedEvent> {

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		ApplicationContext context = event.getApplicationContext();
		String[] beanNames = context.getBeanDefinitionNames();
		for (String beanName : beanNames) {
			Object bean = context.getBean(beanName);
			Method[] methods = bean.getClass().getDeclaredMethods();
			for (Method method : methods) {
				if (method.isAnnotationPresent(PostInitialized.class)) {
					System.out.println("Find method with annotation");
					try {
						method.invoke(bean);
					} catch (IllegalAccessException | IllegalArgumentException
							| InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
