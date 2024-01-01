package cn.elves.parking.application.parking.req;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CheckInReq {

    private String plate;
    private LocalDateTime time;
}
