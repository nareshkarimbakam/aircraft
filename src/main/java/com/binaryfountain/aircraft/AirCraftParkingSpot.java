package com.binaryfountain.aircraft;

import com.binaryfountain.aircraft.model.AirCraft;

public class AirCraftParkingSpot {

    protected AirCraft airCraft;
    protected String size;
    protected String type;
    protected int spotNumber;
    protected SpotSize spotSize;
    protected boolean spotAvailable;
    
    public AirCraftParkingSpot(int spotNumber, String size, String type) {
        this.spotNumber=spotNumber;
        this.size=size;
        this.type=type;
    }
    public int getSpotNumber() {
        return spotNumber;
    }

    public SpotSize getSpotSize() {
        return spotSize;
    }

    public AirCraft getAirCraft() {
        return airCraft;
    }

    public String getSize() {
        return size;
    }

    public String getType() {
        return type;
    }
    
    public boolean isSpaceSufficient(AirCraft ac) {
        if(ac.getSize()==this.getSize()) {
            return true ;
        }else if(this.getSize()=="Large") {
            return true;
        }else {
            if(ac.getSize()=="Small") {
                return true;
            }else {
                return false;
            }
        }
    }

    public boolean park(AirCraft airCraft) {
        if(isSpaceSufficient(airCraft)) {
            this.airCraft = airCraft;
            return true;
        }else
            return false;
    }
    public void removeAirCraft(String id) {
        this.airCraft = null;
    }
    
    public boolean checkPriority(AirCraft ac) {
        if(ac.getType()=="Emergency") {
            return true;
        }else if(ac.getType()=="VIP") {
            return true;
        }else if(ac.getType()=="Passenger") {
            return true;
        }else if(ac.getType()=="Cargo") {
            return true;
        }
        return false;
    }
    public boolean getSpotAvailabile() {
        return spotAvailable;
    }
    public void setSpotAvailable(boolean spotAvailability) {
        this.spotAvailable = spotAvailable;
    }
    
}
