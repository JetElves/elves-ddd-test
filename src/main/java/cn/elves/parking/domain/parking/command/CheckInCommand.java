package cn.elves.parking.domain.parking.command;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CheckInCommand {

    private String plate;

    private LocalDateTime checkInTime;

}
