package cn.elves.parking.application.parking.impl;

import cn.elves.parking.application.parking.ParkingService;
import cn.elves.parking.application.parking.req.CheckInReq;
import cn.elves.parking.application.parking.req.CheckOutReq;
import cn.elves.parking.application.parking.res.ParkingRes;
import cn.elves.parking.domain.parking.CheckInCommandHandler;
import cn.elves.parking.domain.parking.CheckOutCommandHandler;
import cn.elves.parking.domain.parking.ParkingAgg;
import cn.elves.parking.domain.parking.command.CheckInCommand;
import cn.elves.parking.domain.parking.command.CheckOutCommand;
import org.springframework.stereotype.Service;

@Service
public class ParkingServiceImpl implements ParkingService {

    private final CheckInCommandHandler checkInCommandHandler;

    private final CheckOutCommandHandler checkOutCommandHandler;

    public ParkingServiceImpl(CheckInCommandHandler checkInCommandHandler, CheckOutCommandHandler checkOutCommandHandler) {
        this.checkInCommandHandler = checkInCommandHandler;
        this.checkOutCommandHandler = checkOutCommandHandler;
    }

    @Override
    public ParkingRes checkIn(CheckInReq checkInReq) {
        CheckInCommand checkInCommand = CheckInCommand.builder()
                .checkInTime(checkInReq.getTime())
                .plate(checkInReq.getPlate())
                .build();
        ParkingAgg handle = checkInCommandHandler.handle(checkInCommand);
        return buildOrgDto(handle);
    }

    @Override
    public ParkingRes checkOut(CheckOutReq checkOutReq) {
        CheckOutCommand checkOutCommand = CheckOutCommand.builder()
                .checkOutTime(checkOutReq.getTime())
                .plate(checkOutReq.getPlate())
                .build();
        ParkingAgg handle = checkOutCommandHandler.handle(checkOutCommand);
        return buildOrgDto(handle);
    }

    private static ParkingRes buildOrgDto(ParkingAgg parking) {
        ParkingRes response = new ParkingRes();

        return response;
    }
}
