package cn.elves.parking.domain.bookevent.command;

import lombok.Data;

@Data
public class LendOutBookCommand {

    private String userId;

    private String code;

}
