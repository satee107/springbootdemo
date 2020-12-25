package com.fit.demo;
import org.springframework.stereotype.Component;  
@Component  
public class ServiceDemo {
	
	public String getName(String name) {
		return name.toUpperCase();
	}

}
