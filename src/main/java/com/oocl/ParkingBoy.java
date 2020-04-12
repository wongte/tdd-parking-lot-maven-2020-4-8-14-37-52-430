package com.oocl;

import com.oocl.exception.InvalidParkingTicketException;
import com.oocl.exception.NotEnoughPositionException;

import java.util.List;

public class ParkingBoy {
    private final List<ParkingLot> parkingLotList;

    public ParkingBoy(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public ParkingTicket parkCar(Car car) throws NotEnoughPositionException {
        for (ParkingLot parkingLot : parkingLotList) {
            if (!parkingLot.isFull()) {
                return parkingLot.parkCar(car);
            }
        }
        throw new NotEnoughPositionException();
    }

    public Car fetchCar(ParkingTicket ticket) throws InvalidParkingTicketException {
        return parkingLotList.get(0).fetchCar(ticket);
    }
}
