package com.oocl.strategy;

import com.oocl.ParkingLot;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class MostEmptyPositionStrategy implements FinaParkingLotStrategy {
    @Override
    public Optional<ParkingLot> find(List<ParkingLot> parkingLots) {
        return parkingLots
                .stream()
                .filter(lot -> !lot.isFull())
                .max(Comparator.comparingInt(ParkingLot::getNumberOfEmptyLot));
    }
}
