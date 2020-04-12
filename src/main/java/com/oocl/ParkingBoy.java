package com.oocl;

import com.oocl.exception.InvalidParkingTicketException;
import com.oocl.exception.NotEnoughPositionException;

public class ParkingBoy {
    private final ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket parkCar(Car car) throws NotEnoughPositionException {
        return parkingLot.parkCar(car);
    }

    public Car fetchCar(ParkingTicket ticket) throws InvalidParkingTicketException {
        return parkingLot.fetchCar(ticket);
    }
}
