package com.johnkuper.epam.beanpostprocessors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.stereotype.Component;

@Component
public class WarningBeanFactoryPostProcessor implements
		BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory beanFactory) throws BeansException {

		String[] allBeansNames = beanFactory.getBeanDefinitionNames();
		for (String beanDefinitionname : allBeansNames) {
			AbstractBeanDefinition bean = (AbstractBeanDefinition) beanFactory
					.getBeanDefinition(beanDefinitionname);
			String destroyName = bean.getDestroyMethodName();
			if (destroyName != null && bean.isPrototype()) {
				String message = String
						.format("Destroy method '%s' can't be invoke for prototype with name '%s'",
								destroyName, beanDefinitionname);
				System.out.println(message);
			}
		}

	}

}
