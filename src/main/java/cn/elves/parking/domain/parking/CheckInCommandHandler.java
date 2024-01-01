package cn.elves.parking.domain.parking;

import cn.elves.parking.domain.parking.command.CheckInCommand;
import cn.elves.parking.domain.parking.validator.CheckInValidator;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class CheckInCommandHandler {

    @Resource
    private ParkingRepository parkingRepository;

    @Resource
    private CheckInValidator checkInValidator;

    public ParkingAgg handle(CheckInCommand checkInCommand) {
        ParkingAgg parking = parkingRepository.findLastOneByPlate(checkInCommand.getPlate());
        checkInValidator.carShouldNotInPark(parking);
        parking.checkIn(checkInCommand);
        parkingRepository.save(parking);
        return parking;
    }
}
