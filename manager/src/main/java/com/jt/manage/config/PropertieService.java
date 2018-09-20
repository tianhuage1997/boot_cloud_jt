package com.jt.manage.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PropertieService {
	@Value("${pathw}")
	public String pathw;
	@Value("${urlw}")
	public String urlw;
	
}
