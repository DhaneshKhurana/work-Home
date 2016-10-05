package org.dhanesh.main.events;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SpringEventListeners implements ApplicationListener {

	@Override
	public void onApplicationEvent(ApplicationEvent evt) {
		System.out.println("An event occured :: " + evt.toString());
	}
}
