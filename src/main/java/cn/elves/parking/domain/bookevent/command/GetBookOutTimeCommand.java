package cn.elves.parking.domain.bookevent.command;

import lombok.Data;

@Data
public class GetBookOutTimeCommand {


    private String userId;

    private String code;
}
