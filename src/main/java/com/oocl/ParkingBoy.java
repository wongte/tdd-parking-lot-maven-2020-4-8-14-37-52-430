package com.oocl;

import com.oocl.exception.InvalidParkingTicketException;

public class ParkingBoy {
    private final ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket parkCar(Car car) {
        return parkingLot.parkCar(car);
    }

    public Car fetchCar(ParkingTicket ticket) throws InvalidParkingTicketException {
        return parkingLot.fetchCar(ticket);
    }
}
