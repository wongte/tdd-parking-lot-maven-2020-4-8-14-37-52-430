package com.oocl;

import com.oocl.exception.NotEnoughPositionException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class SuperSmartParkingBoy extends ParkingBoy {
    public SuperSmartParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }
    @Override
    public ParkingTicket parkCar(Car car) throws NotEnoughPositionException {
        List<ParkingLot> parkingLotList = this.getParkingLotList();

        Stream<ParkingLot> nonFullParkingLotList = parkingLotList.stream().filter(lot -> !lot.isFull());
        Optional<ParkingLot> parkingLotWithLargestRate = nonFullParkingLotList.max((lot1, lot2) -> {
            double availableRateInLot1 = (double)lot1.getEmptyLot() / lot1.getCapacity();
            double availableRateInLot2 = (double)lot2.getEmptyLot() / lot2.getCapacity();
            return Double.compare(availableRateInLot1, availableRateInLot2);
        });

        return parkingLotWithLargestRate
                .orElseThrow(NotEnoughPositionException::new)
                .parkCar(car);
    }
}
