package com.oocl.exception;

public class ParkingTicketNotFoundException extends InvalidParkingTicketException{
    public ParkingTicketNotFoundException() {
        super("Please provide your parking ticket.");
    }
}
