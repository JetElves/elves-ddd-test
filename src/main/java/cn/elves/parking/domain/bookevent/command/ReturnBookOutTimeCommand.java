package cn.elves.parking.domain.bookevent.command;

import lombok.Data;

@Data
public class ReturnBookOutTimeCommand {


    private String userId;

    private String code;

}
