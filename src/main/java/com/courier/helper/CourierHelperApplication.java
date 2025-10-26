package com.courier.helper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.courier.helper.master.CourierHelperMaster;

@SpringBootApplication
public class CourierHelperApplication {	
	
	public static void main(String[] args) {
		SpringApplication.run(CourierHelperApplication.class, args);
		System.out.println("###################################################################");
		System.out.println("####################################################################");
		System.out.println("###############     Hello, Welcome to Courier Service    ############");
		ApplicationContext context = new AnnotationConfigApplicationContext(
				HelperConfig.class);
		
		CourierHelperMaster master = context.getBean(CourierHelperMaster.class);
		master.startCourerHelperService();
	}

}
