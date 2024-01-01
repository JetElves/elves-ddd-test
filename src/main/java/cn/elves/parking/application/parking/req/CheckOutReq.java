package cn.elves.parking.application.parking.req;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CheckOutReq {

    private String plate;
    private LocalDateTime time;
}
