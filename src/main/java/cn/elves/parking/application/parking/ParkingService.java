package cn.elves.parking.application.parking;

import cn.elves.parking.application.parking.req.CheckInReq;
import cn.elves.parking.application.parking.req.CheckOutReq;
import cn.elves.parking.application.parking.res.ParkingRes;

public interface ParkingService {

    ParkingRes checkIn(CheckInReq checkInReq);

    ParkingRes checkOut(CheckOutReq checkOutReq);
}
