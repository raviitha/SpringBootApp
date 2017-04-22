package com.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.entity.Customer;
import com.project.entity.CustomerRepository;

@Controller
public class GreetingController {
	
	private static final Logger log = LoggerFactory.getLogger(GreetingController.class);
	
	@Autowired
	CustomerRepository repository;
    
	@RequestMapping("/greeting")
	@ResponseBody
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
    Model model) {
	    model.addAttribute("name", name);
	    log.info("In Greeting");
	    repository.save(new Customer("Jack", "Bauer"));
		repository.save(new Customer("Chloe", "O'Brian"));
		repository.save(new Customer("Kim", "Bauer"));
		repository.save(new Customer("David", "Palmer"));
		repository.save(new Customer("Michelle", "Dessler"));
		repository.save(new Customer("Sreekanth", "Akula"));
		repository.save(new Customer("Kiran", "Akula"));
		
		// fetch all customers
		log.info("Customers found with findAll():");
		log.info("-------------------------------");
		for (Customer customer : repository.findAll()) {
			System.out.println(customer.toString());
		}
		
		
		return repository.findByFirstName("Sreekanth").toString();
    }
	 

}
