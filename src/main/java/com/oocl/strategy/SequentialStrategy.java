package com.oocl.strategy;

import com.oocl.ParkingLot;

import java.util.List;
import java.util.Optional;

public class SequentialStrategy implements FinaParkingLotStrategy {
    @Override
    public Optional<ParkingLot> find(List<ParkingLot> parkingLots) {
        return parkingLots
                .stream()
                .filter(parkingLot -> !parkingLot.isFull())
                .findFirst();
    }
}
