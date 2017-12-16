package com.customfilter;

import org.mule.api.MuleMessage;
import org.mule.api.routing.filter.Filter;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


public class FilterProxy implements Filter, ApplicationContextAware {
	private ApplicationContext context;
	private String countryNameProxy;

	@Override
	public boolean accept(MuleMessage message) {
		CountryFilter filter = (CountryFilter) context.getBean(countryNameProxy, CountryFilter.class);
		return filter.accept(message);
	}
	
	public void setcountryNameProxy(String countryNameProxyDetails) {
		this.countryNameProxy = countryNameProxyDetails;
	}

	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		this.context = context;
		
	}

}