package com.oocl;

public class ParkingBoy {
    private final ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket parkCar(Car car) {
        return parkingLot.parkCar(car);
    }

    public Car fetchCar(ParkingTicket ticket) {
        return parkingLot.fetchCar(ticket);
    }
}
