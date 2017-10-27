package com.example.hw1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.SpringVersion;

import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class HelloworldApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloworldApplication.class, args);
		System.out.println("*** HELLO WORLD ***");
		System.out.println("version = " + SpringVersion.getVersion());
	
		Person p = new Person();
		p.setFirstName("John");
		p.setLastName("Doe");
		System.out.println(p.getName());
	
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		Person p2 = (Person)context.getBean("Person");
		p2.setFirstName("Peter");
		p2.setLastName("Smith");
		System.out.println(p2.getName());
		System.out.println(p2.getGender());
		//context.close();
		//context.registerShutdownHook();
		
		Address a = new Address();
		a.setStreet("#35 calceta");
		a.setCityState("Tagbilaran");
		System.out.println(a.toString());
		
		Address a2 = (Address)context.getBean("address");
				
		System.out.println("\n-----------------------\n");
		p2.setAddress(a2);
		System.out.println(p2.getAddress() + "\n");
		
		context.close();
	}
}
