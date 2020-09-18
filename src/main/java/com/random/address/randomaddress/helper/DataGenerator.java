package com.random.address.randomaddress.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import com.github.javafaker.Faker;
import com.random.address.randomaddress.vo.Address;

public class DataGenerator {
	private static ArrayList<Locale> locale = null;
	private static ArrayList<String> counties = null;
	
	static{
		locale= new ArrayList<>();
		locale.add(new Locale("en-US"));
		locale.add(new Locale("nl-NL"));
		locale.add(new Locale("en-CA"));
		locale.add(new Locale("es-MX"));
		
		counties = new ArrayList<>();
		counties.add("Denton");
		counties.add("Essex");
		counties.add("Collin");
		counties.add("Bergan");
		counties.add("Hiltop");
		counties.add("Denver");
		
	}
	
	public Address getAddress(){
		Random rnd = new Random();
		Address addr  = new Address();
		Faker faker = new Faker(getRandomLocale(locale));
		addr.setHouse(rnd.nextInt(100) + "");
		addr.setStreet(faker.address().streetAddress());
		addr.setCity(faker.address().city());
		addr.setCounty(getRandomCounty(counties));
		addr.setPostalCode(faker.address().zipCode());
		addr.setState(faker.address().state());
		addr.setStateCode(faker.address().stateAbbr());
		addr.setCountry(faker.address().country());
		addr.setCountryCode(faker.address().countryCode());
		return addr;
		
	}
	
	private  String getRandomCounty(List<String> locale) {
	    return locale.get(new Random().nextInt(locale.size()));
	}
	
	private  Locale getRandomLocale(List<Locale> locale) {
	    return locale.get(new Random().nextInt(locale.size()));
	}

}
