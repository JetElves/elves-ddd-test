package cn.elves.parking.domain.parking.command;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CheckOutCommand {

    private String plate;

    private LocalDateTime checkOutTime;

}
