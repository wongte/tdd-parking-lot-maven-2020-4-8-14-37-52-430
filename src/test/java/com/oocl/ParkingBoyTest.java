package com.oocl;

import org.junit.Assert;
import org.junit.Test;

public class ParkingBoyTest {
    @Test
    public void test_park_when_give_car_then_return_ticket() {
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car();
        ParkingTicket ticket = parkingBoy.parkCar(car);
        Assert.assertNotNull(ticket);
    }
}
