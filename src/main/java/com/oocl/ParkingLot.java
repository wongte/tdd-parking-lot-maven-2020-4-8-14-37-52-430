package com.oocl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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


    public ParkingTicket parkCar(Car car) {
        if (this.isFull()) {
            return null;
        }
        Set<ParkingTicket> allParkingTickets = ticketCarMap.keySet();
        for (ParkingTicket parkingTicket : allParkingTickets) {
            if (ticketCarMap.get(parkingTicket) == car) {
                return null;
            }
        }
        ParkingTicket ticket = new ParkingTicket();
        ticketCarMap.put(ticket, car);
        return ticket;
    }

    public Car fetchCar(ParkingTicket ticket) {
        return ticketCarMap.remove(ticket);
    }

    public boolean isFull() {
        return this.getCapacity() <= ticketCarMap.size();
    }
}
