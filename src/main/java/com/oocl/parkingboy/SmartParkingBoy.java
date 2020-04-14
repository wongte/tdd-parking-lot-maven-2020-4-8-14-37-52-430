package com.oocl.parkingboy;

import com.oocl.Car;
import com.oocl.ParkingLot;
import com.oocl.ParkingTicket;
import com.oocl.exception.NotEnoughPositionException;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class SmartParkingBoy extends ParkingBoy {
    public SmartParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }

    @Override
    public ParkingTicket park(Car car) throws NotEnoughPositionException {
        List<ParkingLot> parkingLotList = this.getParkingLots();
        Stream<ParkingLot> nonFullParkingLot = parkingLotList.stream().filter(lot -> !lot.isFull());
        Optional<ParkingLot> parkingLotWithHighestEmptyLot = nonFullParkingLot.max(Comparator.comparingInt(ParkingLot::getNumberOfEmptyLot));
        return parkingLotWithHighestEmptyLot
                .orElseThrow(NotEnoughPositionException::new)
                .park(car);
    }
}
