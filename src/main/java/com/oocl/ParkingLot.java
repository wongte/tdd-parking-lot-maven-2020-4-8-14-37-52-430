package com.oocl;

import com.oocl.exception.InvalidParkingTicketException;
import com.oocl.exception.NotEnoughPositionException;
import com.oocl.exception.ParkingTicketNotFoundException;
import com.oocl.exception.UnrecognizedParkingTicketException;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int DEFAULT_CAPACITY = 10;
    private final int capacity;
    private Map<ParkingTicket, Car> ticketCarMap = new HashMap<>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public ParkingLot() {
        this.capacity = DEFAULT_CAPACITY;
    }

    public int getCapacity() {
        return capacity;
    }


    public ParkingTicket park(Car car) throws NotEnoughPositionException {
        if (this.isFull()) {
            throw new NotEnoughPositionException();
        }
        if (this.isContains(car)) {
            return null;
        }
        ParkingTicket ticket = new ParkingTicket();
        ticketCarMap.put(ticket, car);
        return ticket;
    }

    private boolean isContains(Car car) {
        return ticketCarMap.containsValue(car);
    }

    public Car fetch(ParkingTicket ticket) throws InvalidParkingTicketException {
        if (ticket == null) {
            throw new ParkingTicketNotFoundException();
        }
        if (!this.isThisLotTicket(ticket)) {
            throw new UnrecognizedParkingTicketException();
        }
        return ticketCarMap.remove(ticket);
    }

    public boolean isFull() {
        return this.getCapacity() <= ticketCarMap.size();
    }

    public boolean isThisLotTicket(ParkingTicket ticket) {
        return this.ticketCarMap.containsKey(ticket);
    }

    public int getNumberOfEmptyLot() {
        return this.getCapacity() - this.ticketCarMap.size();
    }
}
