package com.customfilter;



import java.util.Random;

import org.apache.log4j.Logger;
import org.mule.api.MuleMessage;
import org.mule.api.routing.filter.Filter;


public class CountryFilter implements Filter {
	private String countryName;
	Logger log = Logger.getLogger(CountryFilter.class);
	
	public CountryFilter() {}
	
	@Override
	public boolean accept(MuleMessage message) {
		countryName = String.valueOf((message.getPayload()));
		log.info(this + " name " + countryName);
		return   countryName.equalsIgnoreCase("India")? true : false;
	}
}
