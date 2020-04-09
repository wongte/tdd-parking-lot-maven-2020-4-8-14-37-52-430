package com.oocl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParkingBoyTest {

    private ParkingBoy parkingBoy;

    @Before
    public void setUp() {
        ParkingLot parkingLot = new ParkingLot(10);
        parkingBoy = new ParkingBoy(parkingLot);
    }

    @Test
    public void test_park_when_give_car_then_return_ticket() {
        Car car = new Car();
        ParkingTicket ticket = parkingBoy.parkCar(car);
        Assert.assertNotNull(ticket);
    }

    @Test
    public void test_fetch_car_when_give_ticket_then_return_car() {
        Car car = new Car();
        ParkingTicket ticket = parkingBoy.parkCar(car);
        Car fetchedCar = parkingBoy.fetchCar(ticket);

        Assert.assertEquals(car, fetchedCar);
    }

    @Test
    public void test_park_multiple_car_when_give_ticket_then_return_correct_car() {
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingTicket ticketWithCar1 = parkingBoy.parkCar(car1);
        parkingBoy.parkCar(car2);
        Car fetchedCar = parkingBoy.fetchCar(ticketWithCar1);

        Assert.assertEquals(car1, fetchedCar);
    }

    @Test
    public void test_fetch_car_when_give_incorrect_ticket_then_not_return_car() {
        Car car = new Car();
        parkingBoy.parkCar(car);
        ParkingTicket invalidTicket = new ParkingTicket();
        Car fetchedCar = parkingBoy.fetchCar(invalidTicket);

        Assert.assertNull(fetchedCar);
    }

    @Test
    public void test_fetch_car_when_dont_give_ticket_then_not_return_car() {
        Car car = new Car();
        parkingBoy.parkCar(car);
        Car fetchedCar = parkingBoy.fetchCar(null);

        Assert.assertNull(fetchedCar);
    }

    @Test
    public void test_fetch_car_when_give_used_ticket_then_not_return_car() {
        Car car = new Car();
        ParkingTicket ticket = parkingBoy.parkCar(car);
        parkingBoy.fetchCar(ticket);
        Car fetchedCarWithUsedTicket = parkingBoy.fetchCar(ticket);

        Assert.assertNull(fetchedCarWithUsedTicket);
    }

    @Test
    public void test_park_car_when_lot_is_full_then_not_return_ticket() {
        for (int times = 1; times <= 10; times++) {
            Car car = new Car();
            parkingBoy.parkCar(car);
        }
        Car carWithFullLot = new Car();
        ParkingTicket ticket = parkingBoy.parkCar(carWithFullLot);

        Assert.assertNull(ticket);
    }

}
