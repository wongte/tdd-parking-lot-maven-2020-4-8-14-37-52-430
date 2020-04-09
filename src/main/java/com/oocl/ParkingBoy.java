package com.oocl;

public class ParkingBoy {
    Car parkedCar = null;
    public ParkingTicket parkCar(Car car) {
        this.parkedCar = car;
        return new ParkingTicket();
    }

    public Car fetchCar(ParkingTicket ticket) {
        return parkedCar;
    }
}
