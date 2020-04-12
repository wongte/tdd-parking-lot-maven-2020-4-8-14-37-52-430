package com.oocl;

import com.oocl.exception.NotEnoughPositionException;
import com.oocl.exception.ParkingTicketNotFoundException;
import com.oocl.exception.UnrecognizedParkingTicketException;
import org.junit.Assert;
import org.junit.Test;

public class ExceptionTest {
    @Test
    public void test_NotEnoughPositionException_message() {
        NotEnoughPositionException thrownException = new NotEnoughPositionException();
        String expectedMessage = "Not enough position.";
        Assert.assertEquals(expectedMessage, thrownException.getMessage());
    }

    @Test
    public void test_ParkingTicketNotFoundException_message() {
        ParkingTicketNotFoundException thrownException = new ParkingTicketNotFoundException();
        String expectedMessage = "Please provide your parking ticket.";
        Assert.assertEquals(expectedMessage, thrownException.getMessage());
    }

    @Test
    public void test_UnrecognizedParkingTicketException_message() {
        UnrecognizedParkingTicketException thrownException = new UnrecognizedParkingTicketException();
        String expectedMessage = "Unrecognized parking ticket.";
        Assert.assertEquals(expectedMessage, thrownException.getMessage());
    }
}
