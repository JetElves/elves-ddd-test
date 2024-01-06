package cn.elves.parking.domain.book.handle;

import cn.elves.parking.domain.book.BookAgg;
import cn.elves.parking.domain.book.BookAggRepository;
import cn.elves.parking.domain.book.command.OffShelvesBookCommand;
import org.springframework.stereotype.Component;

@Component
public class OffShelvesBookCommandHandle {

    private final BookAggRepository bookAggRepository;


    public OffShelvesBookCommandHandle(BookAggRepository bookAggRepository) {
        this.bookAggRepository = bookAggRepository;

    }


    public void handleOffShelvesBookCommand(OffShelvesBookCommand offShelvesBookCommand) {
        BookAgg bookAgg = bookAggRepository.queryBookByCode(offShelvesBookCommand.getCode());
        bookAgg.offShelvesBook();
        bookAggRepository.enterBook(bookAgg);
    }
}
