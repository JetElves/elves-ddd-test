package cn.elves.parking.domain.book.command;

import lombok.Data;

@Data
public class EnterBookCommand {

    private String isbn;

    private String code;

}
