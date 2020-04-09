package com.oocl;

import java.util.HashMap;
import java.util.Map;

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
        ParkingTicket ticket = new ParkingTicket();
        ticketCarMap.put(ticket, car);
        return ticket;
    }

    public Car fetchCar(ParkingTicket ticket) {
        return ticketCarMap.remove(ticket);
    }
}
