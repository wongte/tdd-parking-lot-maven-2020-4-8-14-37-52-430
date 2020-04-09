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
}