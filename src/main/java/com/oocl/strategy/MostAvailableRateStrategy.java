package com.oocl.strategy;

import com.oocl.ParkingLot;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MostAvailableRateStrategy implements FinaParkingLotStrategy {
    @Override
    public Optional<ParkingLot> find(List<ParkingLot> parkingLots) {
        return parkingLots
                .stream()
                .filter(lot -> !lot.isFull())
                .max(Comparator.comparingDouble(this::calculateAvailableRate));
    }

    private double calculateAvailableRate(ParkingLot lot1) {
        return (double) lot1.getNumberOfEmptyLot() / lot1.getCapacity();
    }

}
