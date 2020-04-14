package com.oocl.parkingboy;

import com.oocl.ParkingLot;
import com.oocl.strategy.MostAvailableRateStrategy;

import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy {
    public SuperSmartParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
        this.finaParkingLotStrategy = new MostAvailableRateStrategy();
    }
}
