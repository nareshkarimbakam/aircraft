package com.binaryfountain.aircraft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.binaryfountain.aircraft.AirCraftParkingSpot;
import com.binaryfountain.aircraft.model.AirCraft;
import com.binaryfountain.aircraft.service.AirCraftLotService;

@RestController
public class AirCraftController {

    @Autowired
    AirCraftLotService airCraftLotService;
    
    @RequestMapping(value = "/spot/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AirCraftParkingSpot> getParkingSpot(@PathVariable("id") int id) {
        System.out.println("Fetching Parking spot with id " + id);
        AirCraftParkingSpot spot = airCraftLotService.findById(id);
        if (spot == null) {
            System.out.println("Spot with id " + id + " not found");
            return new ResponseEntity<AirCraftParkingSpot>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<AirCraftParkingSpot>(spot, HttpStatus.OK);
    }
 

    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ResponseEntity<Void> enQueue(@RequestBody AirCraft ac) {
        System.out.println("Parking aircraft " + ac.getId());
 
        airCraftLotService.park(ac);
 
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
 

    @RequestMapping(value = "/spot/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<AirCraft> deQueue(@PathVariable("id") int id) {
        
        AirCraftParkingSpot spot = airCraftLotService.findById(id);
        if (spot == null) {
            System.out.println("Unable to delete. Spot with id " + id + " not found");
            return new ResponseEntity<AirCraft>(HttpStatus.NOT_FOUND);
        }
 
        airCraftLotService.removeAirCraft(id);
        return new ResponseEntity<AirCraft>(HttpStatus.NO_CONTENT);
    }
 
	/* for delete air crafts
	
	*/
    @RequestMapping(value = "/user/", method = RequestMethod.DELETE)
    public ResponseEntity<AirCraft> deleteAllAirCrafts() {
        System.out.println("Deleting All aircrafts");
 
        airCraftLotService.deleteAllAirCrafts();
        return new ResponseEntity<AirCraft>(HttpStatus.NO_CONTENT);
    }
 }
