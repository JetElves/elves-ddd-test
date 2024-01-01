package cn.elves.parking.domain.parking;

import cn.elves.parking.domain.parking.command.CheckOutCommand;
import cn.elves.parking.domain.parking.validator.CheckOutValidator;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class CheckOutCommandHandler {

    @Resource
    private ParkingRepository parkingRepository;

    @Resource
    private CheckOutValidator checkOutValidator;

    public ParkingAgg handle(CheckOutCommand checkOutCommand) {
        ParkingAgg parking = parkingRepository.findLastOneByPlate(checkOutCommand.getPlate());
        checkOutValidator.carShouldInPark(parking);
        parking.checkOut(checkOutCommand);
        parkingRepository.save(parking);
        return parking;
    }
}
