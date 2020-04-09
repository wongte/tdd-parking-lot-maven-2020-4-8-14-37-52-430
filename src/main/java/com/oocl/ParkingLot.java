package com.oocl;

public class ParkingLot {
    private final int DEFAULT_CAPACITY = 10;
    private final int capacity;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public ParkingLot() {
        this.capacity = DEFAULT_CAPACITY;
    }

    public int getCapacity() {
        return capacity;
    }
}
