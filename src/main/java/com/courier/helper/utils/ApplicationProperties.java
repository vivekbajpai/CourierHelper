package com.courier.helper.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("file:config.properties")
public class ApplicationProperties {
	
	@Autowired
	Environment env;
	
	public String getValue(String key) {
		return env.getProperty(key);
	}
}
