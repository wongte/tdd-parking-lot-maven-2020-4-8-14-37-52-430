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
    private Map<ParkingTicket, Car> ticketCarMap = new HashMap<ParkingTicket, Car>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public ParkingLot() {
        this.capacity = DEFAULT_CAPACITY;
    }

    public int getCapacity() {
        return capacity;
    }


    public ParkingTicket parkCar(Car car) throws NotEnoughPositionException {
        if (this.isFull()) {
            throw new NotEnoughPositionException();
        }
        if (this.isContainsCar(car)) {
            return null;
        }
        ParkingTicket ticket = new ParkingTicket();
        ticketCarMap.put(ticket, car);
        return ticket;
    }

    private boolean isContainsCar(Car car) {
        return ticketCarMap.containsValue(car);
    }

    public Car fetchCar(ParkingTicket ticket) throws InvalidParkingTicketException {
        if (ticket == null) {
            throw new ParkingTicketNotFoundException();
        }
        if (!this.ticketCarMap.containsKey(ticket)) {
            throw new UnrecognizedParkingTicketException();
        }
        return ticketCarMap.remove(ticket);
    }

    public boolean isFull() {
        return this.getCapacity() <= ticketCarMap.size();
    }
}
