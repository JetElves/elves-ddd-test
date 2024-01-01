package cn.elves.parking.adaptor.rest;


import cn.elves.parking.application.parking.ParkingService;
import cn.elves.parking.application.parking.req.CheckInReq;
import cn.elves.parking.application.parking.req.CheckOutReq;
import cn.elves.parking.application.parking.res.ParkingRes;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParkController {

    private final ParkingService parkingService;

    public ParkController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }


    @PatchMapping("checkIn")
    public ParkingRes checkIn(
            @RequestBody CheckInReq checkInReq) {
        return parkingService.checkIn(checkInReq);
    }

    @PatchMapping("checkOut")
    public ParkingRes checkOut(
            @RequestBody CheckOutReq checkOutReq) {
        return parkingService.checkOut(checkOutReq);
    }
}
