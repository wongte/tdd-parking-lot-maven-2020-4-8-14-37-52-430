package com.oocl.strategy;

import com.oocl.ParkingLot;

import java.util.List;
import java.util.Optional;

public interface FinaParkingLotStrategy {
    Optional<ParkingLot> find(List<ParkingLot> parkingLots);
}
