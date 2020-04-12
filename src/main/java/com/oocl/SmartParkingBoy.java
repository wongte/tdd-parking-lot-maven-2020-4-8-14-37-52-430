package com.oocl;

import com.oocl.exception.NotEnoughPositionException;

import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy extends ParkingBoy {
    public SmartParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }

    @Override
    public ParkingTicket parkCar(Car car) throws NotEnoughPositionException {
        List<ParkingLot> parkingLotList = this.getParkingLotList();
        parkingLotList.sort(Comparator.comparingInt(ParkingLot::getEmptyLot).reversed());
        for (ParkingLot parkingLot : parkingLotList) {
            if (!parkingLot.isFull()) {
                return parkingLot.parkCar(car);
            }
        }
        throw new NotEnoughPositionException();
    }
}
