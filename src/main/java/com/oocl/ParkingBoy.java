package com.oocl;

import java.util.HashMap;
import java.util.Map;

public class ParkingBoy {
    Map<ParkingTicket, Car> ticketCarMap = new HashMap<ParkingTicket, Car>();

    public ParkingTicket parkCar(Car car) {
        ParkingTicket ticket = new ParkingTicket();
        ticketCarMap.put(ticket, car);
        return ticket;
    }

    public Car fetchCar(ParkingTicket ticket) {
        return ticketCarMap.get(ticket);
    }
}
