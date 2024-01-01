package cn.elves.parking.domain.parking.validator;

import cn.elves.parking.domain.parking.ParkingAgg;
import cn.elves.parking.domain.parking.exception.CarStatusException;

public class CheckOutValidator {

    public void carShouldInPark(ParkingAgg parking){
        if(parking.getCheckInTime() != null){
            throw new CarStatusException("车辆没有在停车场内");
        }
    }
}
