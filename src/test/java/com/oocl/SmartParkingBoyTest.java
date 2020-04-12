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
    public void test_smart_parking_boy_park_when_lot1_has_more_empty() throws NotEnoughPositionException, InvalidParkingTicketException {
        ParkingLot lot1 = new ParkingLot(2);
        ParkingLot lot2 = new ParkingLot(2);
        lot2.parkCar(new Car());
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(lot1);
        parkingLotList.add(lot2);
        parkingBoy = new SmartParkingBoy(parkingLotList);

        Car carInLot1 = new Car();
        ParkingTicket ticketInLot1 = parkingBoy.parkCar(carInLot1);

        Car carFetchedInLot1 = lot1.fetchCar(ticketInLot1);
        Assert.assertEquals(carFetchedInLot1, carInLot1);
        Assert.assertThrows(UnrecognizedParkingTicketException.class, () -> lot2.fetchCar(ticketInLot1));
    }

    @Test
    public void test_smart_parking_boy_park_when_lot2_has_more_empty() throws NotEnoughPositionException, InvalidParkingTicketException {
        ParkingLot lot1 = new ParkingLot(2);
        ParkingLot lot2 = new ParkingLot(2);
        List<ParkingLot> parkingLotList = new ArrayList<>();
        lot1.parkCar(new Car());
        parkingLotList.add(lot1);
        parkingLotList.add(lot2);
        parkingBoy = new SmartParkingBoy(parkingLotList);

        Car carInLot2 = new Car();
        ParkingTicket ticketInLot2 = parkingBoy.parkCar(carInLot2);

        Car carFetchedInLot2 = lot2.fetchCar(ticketInLot2);
        Assert.assertEquals(carFetchedInLot2, carInLot2);
        Assert.assertThrows(UnrecognizedParkingTicketException.class, () -> lot1.fetchCar(ticketInLot2));
    }

}