package com.oocl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParkingBoyTest {

    public static final int PARKING_LOT_CAPACITY = 10;
    private ParkingBoy parkingBoy;

    @Before
    public void setUp() {
        ParkingLot parkingLot = new ParkingLot(PARKING_LOT_CAPACITY);
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
        for (int times = 1; times <= PARKING_LOT_CAPACITY; times++) {
            Car car = new Car();
            parkingBoy.parkCar(car);
        }
        Car carWithFullLot = new Car();
        ParkingTicket ticket = parkingBoy.parkCar(carWithFullLot);

        Assert.assertNull(ticket);
    }

    @Test
    public void test_park_car_with_parked_car_then_not_return_ticket() {
        Car car = new Car();
        parkingBoy.parkCar(car);
        ParkingTicket ticketWithParkedCar = parkingBoy.parkCar(car);

        Assert.assertNull(ticketWithParkedCar);
    }

}
