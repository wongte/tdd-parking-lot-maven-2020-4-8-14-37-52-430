package com.oocl;

import com.oocl.exception.InvalidParkingTicketException;
import com.oocl.exception.NotEnoughPositionException;
import com.oocl.exception.ParkingTicketNotFoundException;
import com.oocl.exception.UnrecognizedParkingTicketException;

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
        if (ticket == null) {
            throw new ParkingTicketNotFoundException();
        }
        for (ParkingLot parkingLot : parkingLotList) {
            if (parkingLot.isThisLotTicket(ticket)) {
                return parkingLot.fetchCar(ticket);
            }
        }
        throw new UnrecognizedParkingTicketException();
    }
}
