package com.binaryfountain.aircraft.service;

import java.util.List;

import com.binaryfountain.aircraft.AirCraftParkingSpot;
import com.binaryfountain.aircraft.model.AirCraft;

public interface AirCraftLotService {

    AirCraftParkingSpot findById(int id);
    
   // AirCraft findByName(String name);
    
    void park(AirCraft ac);
    
    void removeAirCraft(int id);

    List<AirCraft> findAllAirCrafts(); 
    
    void deleteAllAirCrafts();
    
    public boolean isAirCraftExists(AirCraft ac);
    
    public List<AirCraftParkingSpot> findAllSpots();
}
