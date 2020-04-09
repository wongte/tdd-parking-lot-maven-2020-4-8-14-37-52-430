package com.oocl;

import org.junit.Assert;
import org.junit.Test;

public class ParkingLotTest {

    @Test
    public void test_getCapacity() {
        int capacity = 10;
        ParkingLot parkingLot = new ParkingLot(capacity);
        Assert.assertEquals(capacity, parkingLot.getCapacity());
    }

    @Test
    public void test_isFull_when_park_is_full_return_true() {
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.parkCar(new Car());
        Assert.assertTrue(parkingLot.isFull());
    }

    @Test
    public void test_isFull_when_park_is_not_full_return_false() {
        ParkingLot parkingLot = new ParkingLot(2);
        parkingLot.parkCar(new Car());
        Assert.assertFalse(parkingLot.isFull());
    }
}