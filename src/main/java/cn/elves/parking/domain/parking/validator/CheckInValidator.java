package cn.elves.parking.domain.parking.validator;

import cn.elves.parking.domain.parking.ParkingAgg;
import cn.elves.parking.domain.parking.exception.CarStatusException;

public class CheckInValidator {

    public void carShouldNotInPark(ParkingAgg parking){
        if(parking.getCheckInTime() != null){
            throw new CarStatusException("车辆已在停车场内");
        }
    }
}
