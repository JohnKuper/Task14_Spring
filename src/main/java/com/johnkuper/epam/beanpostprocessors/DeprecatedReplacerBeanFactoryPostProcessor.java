package com.johnkuper.epam.beanpostprocessors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;

import com.johnkuper.epam.annotation.MyDeprecated;

public class DeprecatedReplacerBeanFactoryPostProcessor implements
		BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory beanFactory) throws BeansException {
		String[] allBeansNames = beanFactory.getBeanDefinitionNames();
		for (String beanDefinitionname : allBeansNames) {
			AbstractBeanDefinition beanDefinition = (AbstractBeanDefinition) beanFactory
					.getBeanDefinition(beanDefinitionname);
			String originalClassName = beanDefinition.getBeanClassName();
			try {
				Class<?> originalClass = Class.forName(originalClassName);
				MyDeprecated annotaion = originalClass
						.getAnnotation(MyDeprecated.class);
				if (annotaion != null) {
					beanDefinition.setBeanClass(annotaion.newClass());
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
