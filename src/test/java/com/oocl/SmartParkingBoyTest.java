package com.oocl;

import com.oocl.exception.InvalidParkingTicketException;
import com.oocl.exception.NotEnoughPositionException;
import com.oocl.exception.UnrecognizedParkingTicketException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SmartParkingBoyTest {
    public SmartParkingBoy parkingBoy;

    @Test
    public void test_smart_parking_boy_park_in_more_empty_lot() throws NotEnoughPositionException, InvalidParkingTicketException {
        ParkingLot parkingLotWithLessEmpty = new ParkingLot(1);
        ParkingLot parkingLotWithMoreEmpty = new ParkingLot(2);
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(parkingLotWithLessEmpty);
        parkingLotList.add(parkingLotWithMoreEmpty);
        parkingBoy = new SmartParkingBoy(parkingLotList);

        Car carInLotWithMoreEmpty = new Car();
        ParkingTicket ticketInLotWithMoreEmpty = parkingBoy.parkCar(carInLotWithMoreEmpty);

        Car carFetchedInLot2 = parkingLotWithMoreEmpty.fetchCar(ticketInLotWithMoreEmpty);
        Assert.assertEquals(carFetchedInLot2, carInLotWithMoreEmpty);
        Assert.assertThrows(UnrecognizedParkingTicketException.class, () -> parkingLotWithLessEmpty.fetchCar(ticketInLotWithMoreEmpty));
    }

}