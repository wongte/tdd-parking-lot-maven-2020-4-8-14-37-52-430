package com.oocl.parkingboy;

import com.oocl.Car;
import com.oocl.ParkingLot;
import com.oocl.ParkingTicket;
import com.oocl.exception.InvalidParkingTicketException;
import com.oocl.exception.NotEnoughPositionException;
import com.oocl.exception.ParkingTicketNotFoundException;
import com.oocl.exception.UnrecognizedParkingTicketException;

import java.util.List;

public class ParkingBoy {
    private final List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLotList) {
        this.parkingLots = parkingLotList;
    }

    public ParkingTicket park(Car car) throws NotEnoughPositionException {
        for (ParkingLot parkingLot : parkingLots) {
            if (!parkingLot.isFull()) {
                return parkingLot.park(car);
            }
        }
        throw new NotEnoughPositionException();
    }

    public Car fetch(ParkingTicket ticket) throws InvalidParkingTicketException {
        if (ticket == null) {
            throw new ParkingTicketNotFoundException();
        }
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.isThisLotTicket(ticket)) {
                return parkingLot.fetch(ticket);
            }
        }
        throw new UnrecognizedParkingTicketException();
    }

    protected List<ParkingLot> getParkingLots() {
        return parkingLots;
    }
}
