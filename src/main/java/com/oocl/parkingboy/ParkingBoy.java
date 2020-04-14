package com.oocl.parkingboy;

import com.oocl.Car;
import com.oocl.ParkingLot;
import com.oocl.ParkingTicket;
import com.oocl.exception.InvalidParkingTicketException;
import com.oocl.exception.NotEnoughPositionException;
import com.oocl.exception.ParkingTicketNotFoundException;
import com.oocl.exception.UnrecognizedParkingTicketException;

import java.util.List;
import java.util.Optional;

public class ParkingBoy {
    private final List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLotList) {
        this.parkingLots = parkingLotList;
    }

    public ParkingTicket park(Car car) throws NotEnoughPositionException {
        Optional<ParkingLot> firstNonFullLot = parkingLots
                .stream()
                .filter(parkingLot -> !parkingLot.isFull())
                .findFirst();

        return firstNonFullLot
                .orElseThrow(NotEnoughPositionException::new)
                .park(car);
    }

    public Car fetch(ParkingTicket ticket) throws InvalidParkingTicketException {
        if (ticket == null) {
            throw new ParkingTicketNotFoundException();
        }
        Optional<ParkingLot> firstMatchParkingLot = parkingLots
                .stream()
                .filter(parkingLot -> parkingLot.isThisLotTicket(ticket))
                .findFirst();

        return firstMatchParkingLot
                .orElseThrow(UnrecognizedParkingTicketException::new)
                .fetch(ticket);
    }

    protected List<ParkingLot> getParkingLots() {
        return parkingLots;
    }
}
