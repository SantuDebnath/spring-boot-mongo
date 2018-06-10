package com.example.ademo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Hotel;
import com.example.model.QHotel;
import com.example.repository.HotelRepository;
import com.querydsl.core.types.dsl.BooleanExpression;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	private HotelRepository hr;
	


	
	@RequestMapping("/allHotels")
	public List<Hotel> getAllHotels(){
		return hr.findAll();
		
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public void insert(@RequestBody Hotel hotel){
		hr.insert(hotel);
	}
	
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	public void update(@RequestBody Hotel hotel){
		hr.save(hotel);
	}
	@RequestMapping(value="/delete/{id}")
	public void delete(@PathVariable String id){
		hr.deleteById(id);
	}
	
	@RequestMapping(value="/hotel/{id}",method=RequestMethod.GET)
	public Hotel findByHotelId(@PathVariable String id){
		
		Optional<Hotel> hotel = hr.findById(id);
		if(hotel.isPresent()){
		return hotel.get();
		}else{
			return null;
		}
	}
	
	
	@RequestMapping(value="/price/{price}",method=RequestMethod.GET)
	public List<Hotel> findHotelLessThanPrice(@PathVariable String price){
		
		return hr.findBypricePerNightLessThan(price);
	}
	
	@RequestMapping("/country/{country}")
	public List<Hotel> getHotelsByCountry(@PathVariable String country){
		QHotel qhotel = new QHotel("hotel"); 
		BooleanExpression filterByCountry = qhotel.address.country.eq(country);
		List<Hotel> hotels = (List<Hotel>) hr.findAll(filterByCountry);
		return hotels;
	}
	
    @RequestMapping("/address/{city}")
    public List<Hotel> getByCity(@PathVariable("city") String city){
        List<Hotel> hotels = hr.findByCity(city);

        return hotels;
    }
    
    @RequestMapping("/getRecomendedHotels")
    public List<Hotel> getRecomendedHotels(){
    	QHotel qhotel = new QHotel("hotel");
    	BooleanExpression filterprice = qhotel.pricePerNight.gt("100");
    	BooleanExpression filterrating = qhotel.reviews.any().rating.gt("4");
    	
    	List<Hotel> hotels =(List<Hotel>) hr.findAll(filterprice.and(filterrating));
    	return hotels;
    }
}
