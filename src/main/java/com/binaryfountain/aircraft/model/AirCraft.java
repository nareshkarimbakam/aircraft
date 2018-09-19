package com.binaryfountain.aircraft.model;

public class AirCraft {
    private String id;
    private String name;
    private String type;
    private String size;
    protected int spotRequired;

    public int getSpotRequired() {
        return spotRequired;
    }
    public void setSpotRequired(int spotRequired) {
        this.spotRequired = spotRequired;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }
}
