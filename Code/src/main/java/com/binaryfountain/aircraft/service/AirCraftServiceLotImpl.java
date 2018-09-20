package com.binaryfountain.aircraft.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.binaryfountain.aircraft.AirCraftParkingSpot;
import com.binaryfountain.aircraft.model.AirCraft;

public class AirCraftServiceLotImpl implements AirCraftLotService{

    private static List<AirCraftParkingSpot> parkingLot;
    
    static {
        parkingLot = loadParkingSpots();
    }
    @Override
    public AirCraftParkingSpot findById(int id) {
        for(AirCraftParkingSpot spot : parkingLot) {
            if(spot.getSpotNumber() == id) {
                return spot;
            }
        }
        return null;
    }

 /*   @Override
    public AirCraft findByName(String name) {
        return null;
    }*/

    @Override
    public void park(AirCraft ac) {
        for(AirCraftParkingSpot spot : parkingLot) {
            if(spot.getSpotAvailabile()== true) {
                if(spot.isSpaceSufficient(ac)) {
                    spot.park(ac);
                    break;
                }
            }
        }
    }

    @Override
    public List<AirCraft> findAllAirCrafts() {
        return null;
    }

    @Override
    public void deleteAllAirCrafts() {
        parkingLot.clear();
    }

    @Override
    public boolean isAirCraftExists(AirCraft ac) {
        return false;
    }

    @Override
    public void removeAirCraft(int id) {
        for (Iterator<AirCraftParkingSpot> iterator = parkingLot.iterator(); iterator.hasNext(); ) {
            AirCraftParkingSpot spot = iterator.next();
            if (spot.getSpotNumber() == id) {
                iterator.remove();
            }
        }

    }
    
    private static List<AirCraftParkingSpot> loadParkingSpots(){
        List<AirCraftParkingSpot> lot = new ArrayList<AirCraftParkingSpot>();
        lot.add(new AirCraftParkingSpot(1,"Large",null));
        lot.add(new AirCraftParkingSpot(2,"Large",null));
        lot.add(new AirCraftParkingSpot(3,"Large",null));
        lot.add(new AirCraftParkingSpot(4,"Small",null));
        lot.add(new AirCraftParkingSpot(5,"Small",null));
        lot.add(new AirCraftParkingSpot(6,"Small",null));
        lot.add(new AirCraftParkingSpot(7,"Small",null));
        lot.add(new AirCraftParkingSpot(8,"Small",null));
        lot.add(new AirCraftParkingSpot(9,"Small",null));
        return lot;
    }

    @Override
    public List<AirCraftParkingSpot> findAllSpots() {
        return parkingLot;
    }
}
