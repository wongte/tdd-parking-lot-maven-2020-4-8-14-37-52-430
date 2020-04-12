package com.oocl;

import com.oocl.exception.InvalidParkingTicketException;
import com.oocl.exception.NotEnoughPositionException;
import com.oocl.exception.ParkingTicketNotFoundException;
import com.oocl.exception.UnrecognizedParkingTicketException;
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
    public void test_park_when_give_car_then_return_ticket() throws NotEnoughPositionException {
        Car car = new Car();
        ParkingTicket ticket = parkingBoy.parkCar(car);
        Assert.assertNotNull(ticket);
    }

    @Test
    public void test_fetch_car_when_give_ticket_then_return_car() throws InvalidParkingTicketException, NotEnoughPositionException {
        Car car = new Car();
        ParkingTicket ticket = parkingBoy.parkCar(car);
        Car fetchedCar = parkingBoy.fetchCar(ticket);

        Assert.assertEquals(car, fetchedCar);
    }

    @Test
    public void test_park_multiple_car_when_give_ticket_then_return_correct_car() throws InvalidParkingTicketException, NotEnoughPositionException {
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingTicket ticketWithCar1 = parkingBoy.parkCar(car1);
        parkingBoy.parkCar(car2);
        Car fetchedCar = parkingBoy.fetchCar(ticketWithCar1);

        Assert.assertEquals(car1, fetchedCar);
    }

    @Test
    public void test_fetch_car_when_give_incorrect_ticket_then_throw_unrecognized_ticket_exception() throws NotEnoughPositionException {
        Car car = new Car();
        parkingBoy.parkCar(car);
        ParkingTicket invalidTicket = new ParkingTicket();
        Assert.assertThrows(UnrecognizedParkingTicketException.class, () -> parkingBoy.fetchCar(invalidTicket));
    }

    @Test
    public void test_fetch_car_when_dont_give_ticket_then_throw_ticket_not_found_exception() throws NotEnoughPositionException {
        Car car = new Car();
        parkingBoy.parkCar(car);
        Assert.assertThrows(ParkingTicketNotFoundException.class, () -> parkingBoy.fetchCar(null));
    }

    @Test
    public void test_fetch_car_when_give_used_ticket_then_throw_unrecognized_ticket_exception() throws InvalidParkingTicketException, NotEnoughPositionException {
        Car car = new Car();
        ParkingTicket ticket = parkingBoy.parkCar(car);
        parkingBoy.fetchCar(ticket);
        Assert.assertThrows(UnrecognizedParkingTicketException.class, () -> parkingBoy.fetchCar(ticket));
    }

    @Test
    public void test_park_car_when_lot_is_full_then_throw_not_enough_position_exception() throws NotEnoughPositionException{
        for (int times = 1; times <= PARKING_LOT_CAPACITY; times++) {
            Car car = new Car();
            parkingBoy.parkCar(car);
        }
        Car carWithFullLot = new Car();
        Assert.assertThrows(NotEnoughPositionException.class, () -> parkingBoy.parkCar(carWithFullLot) );
    }

    @Test
    public void test_park_car_with_parked_car_then_not_return_ticket() throws NotEnoughPositionException {
        Car car = new Car();
        parkingBoy.parkCar(car);
        ParkingTicket ticketWithParkedCar = parkingBoy.parkCar(car);

        Assert.assertNull(ticketWithParkedCar);
    }

}
