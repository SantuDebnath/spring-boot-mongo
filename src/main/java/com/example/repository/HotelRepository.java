package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.example.model.Hotel;

@Repository
public interface HotelRepository extends MongoRepository<Hotel, String>, QuerydslPredicateExecutor<Hotel>{

	
	 public Optional<Hotel> findById(String id);
	 
	 @Query(value = "{'address.city':?0}")
	 public List<Hotel> findByCity(String city);
	 
	 public List<Hotel> findBypricePerNightLessThan(String pricePerNight);
}
