package org.dhanesh.main;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class BeanFactoryPostProcessorImpl implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory arg0) throws BeansException {
		System.out.println("YO I AM BEAN POST PROCESSOR FACTORY");
	}

}
