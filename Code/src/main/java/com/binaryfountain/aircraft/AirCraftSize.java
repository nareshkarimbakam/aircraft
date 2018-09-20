package com.binaryfountain.aircraft;

public enum AirCraftSize {
Large(2), Small(1);
    private int isSizeCanAccommodate;
    private AirCraftSize(int value) {
        this.isSizeCanAccommodate = value;
    }
}
