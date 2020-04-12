package com.oocl;

import com.oocl.exception.InvalidParkingTicketException;
import com.oocl.exception.NotEnoughPositionException;
import com.oocl.exception.UnrecognizedParkingTicketException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SuperSmartParkingBoyTest {
    public SuperSmartParkingBoy parkingBoy;

    @Test
    public void test_super_smart_parking_boy_park_when_lot2_has_larger_rate() throws NotEnoughPositionException, InvalidParkingTicketException {
        // available position rate = (positions available / total capacity)
        ParkingLot parkingLot1 = new ParkingLot(4); // rate = 2 / 4 = 0.5
        ParkingLot parkingLot2 = new ParkingLot(3); // rate = 2 / 3 = 0.66
        parkingLot1.parkCar(new Car());
        parkingLot1.parkCar(new Car());
        parkingLot2.parkCar(new Car());

        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(parkingLot1);
        parkingLotList.add(parkingLot2);
        parkingBoy = new SuperSmartParkingBoy(parkingLotList);

        Car carInLot2 = new Car();
        ParkingTicket ticketInLot2 = parkingBoy.parkCar(carInLot2);

        Car carFetchedInLot2 = parkingLot2.fetchCar(ticketInLot2);
        Assert.assertEquals(carFetchedInLot2, carInLot2);
        Assert.assertThrows(UnrecognizedParkingTicketException.class, () -> parkingLot1.fetchCar(ticketInLot2));
    }

    @Test
    public void test_super_smart_parking_boy_park_when_lot1_has_larger_rate() throws NotEnoughPositionException, InvalidParkingTicketException {
        // available position rate = (positions available / total capacity)
        ParkingLot parkingLot1 = new ParkingLot(3); // rate = 2 / 3 = 0.66
        ParkingLot parkingLot2 = new ParkingLot(4); // rate = 2 / 4 = 0.5

        parkingLot1.parkCar(new Car());
        parkingLot2.parkCar(new Car());
        parkingLot2.parkCar(new Car());

        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(parkingLot1);
        parkingLotList.add(parkingLot2);
        parkingBoy = new SuperSmartParkingBoy(parkingLotList);

        Car carInLot1 = new Car();
        ParkingTicket ticketInLot1 = parkingBoy.parkCar(carInLot1);

        Car carFetchedInLot1 = parkingLot1.fetchCar(ticketInLot1);
        Assert.assertEquals(carFetchedInLot1, carInLot1);
        Assert.assertThrows(UnrecognizedParkingTicketException.class, () -> parkingLot2.fetchCar(ticketInLot1));
    }

}