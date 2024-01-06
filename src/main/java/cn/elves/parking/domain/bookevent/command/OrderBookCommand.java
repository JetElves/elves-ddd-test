package cn.elves.parking.domain.bookevent.command;

import lombok.Data;

@Data
public class OrderBookCommand {


    private String userId;

    private String isbn;
}
