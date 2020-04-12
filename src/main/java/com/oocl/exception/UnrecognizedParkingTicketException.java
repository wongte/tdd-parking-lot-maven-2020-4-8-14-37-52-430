package com.oocl.exception;

public class UnrecognizedParkingTicketException extends InvalidParkingTicketException {
    public UnrecognizedParkingTicketException() {
        super("Unrecognized parking ticket.");
    }
}
