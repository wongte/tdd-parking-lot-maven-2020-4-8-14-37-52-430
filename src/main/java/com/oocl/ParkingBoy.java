package com.oocl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ParkingBoy {
    private final ParkingLot parkingLot;
    Map<ParkingTicket, Car> ticketCarMap = new HashMap<ParkingTicket, Car>();

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket parkCar(Car car) {
        if (parkingLot.getCapacity() <= ticketCarMap.size()) {
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
}
