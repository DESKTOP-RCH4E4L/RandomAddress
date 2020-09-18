package com.random.address.randomaddress.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.random.address.randomaddress.helper.DataGenerator;
import com.random.address.randomaddress.vo.Address;

@RestController
public class AddressController extends SpringBootServletInitializer{
	
	private Log log = LogFactory.getLog(AddressController.class);
	
	@GetMapping("/randomizer/address")
	public String  getRandomAddress(){
		String data = null;
		
		DataGenerator gen = new DataGenerator();
		Address addr = gen.getAddress();
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		try {
			data = ow.writeValueAsString(addr);
		} catch (JsonProcessingException e) {
			log.error(e, e);
			data = "Error converting address object";
		}
		
		log.info(data);
		
		return data;
	}

}
