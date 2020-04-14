package com.oocl.parkingboy;

import com.oocl.ParkingLot;
import com.oocl.strategy.MostEmptyPositionStrategy;

import java.util.List;

public class SmartParkingBoy extends ParkingBoy {
    public SmartParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
        this.finaParkingLotStrategy = new MostEmptyPositionStrategy();
    }

}
