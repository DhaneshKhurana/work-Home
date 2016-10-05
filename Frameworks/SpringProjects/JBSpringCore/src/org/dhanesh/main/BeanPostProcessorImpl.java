package org.dhanesh.main;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BeanPostProcessorImpl implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("AFTER Post processor: " + " beanName :: " + beanName);
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Before Post processor: " + " beanName :: " + beanName);
		return bean;
	}

}
