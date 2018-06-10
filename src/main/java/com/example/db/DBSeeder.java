package com.example.db;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.model.Address;
import com.example.model.Hotel;
import com.example.model.Review;
import com.example.repository.HotelRepository;

@Component
public class DBSeeder implements CommandLineRunner {
	
	private HotelRepository hr;
	public DBSeeder(HotelRepository hr){
		this.hr= hr;
	}

	@Override
	public void run(String... args) throws Exception {
		Address add1 = new Address("kolkata","India");
		List<Review> reviews = new ArrayList<Review>();
		reviews.add(new Review("santu", "5", true));
		Hotel novotel = new Hotel("Novotel", "100", add1, reviews);
		
		Address add2 = new Address("paris","France");
		List<Review> reviews2 = new ArrayList<Review>();
		reviews2.add(new Review("deb", "5", true));
		reviews2.add(new Review("patrik", "3", true));
		reviews2.add(new Review("rubi", "7", true));
		Hotel marriot = new Hotel("montril", "500", add2, reviews2);
		
		Address add3 = new Address("rome","italy");
		List<Review> reviews3 = new ArrayList<Review>();
		reviews3.add(new Review("manish", "5", true));
		reviews3.add(new Review("alfred", "4", true));
		reviews3.add(new Review("debian", "7", true));
		Hotel monotel = new Hotel("Monotel", "200", add3, reviews3);
		
		//Dropping hotels
		this.hr.deleteAll();
		
		//creating new hotels
		List<Hotel> hotels = new ArrayList<Hotel>();
		hotels.add(monotel);
		hotels.add(marriot);
		hotels.add(novotel);
		
		this.hr.saveAll(hotels);
	}
	
}
