package cn.elves.parking.domain.book.handle;

import cn.elves.parking.domain.book.BookAgg;
import cn.elves.parking.domain.book.BookAggRepository;
import cn.elves.parking.domain.book.command.OnShelvesBookCommand;
import org.springframework.stereotype.Component;

@Component
public class OnShelvesBookCommandHandle {

    private final BookAggRepository bookAggRepository;


    public OnShelvesBookCommandHandle(BookAggRepository bookAggRepository) {
        this.bookAggRepository = bookAggRepository;

    }


    public void handleOnShelvesBookCommand(OnShelvesBookCommand onShelvesBookCommand) {
        BookAgg bookAgg = bookAggRepository.queryBookByCode(onShelvesBookCommand.getCode());
        bookAgg.onShelvesBook();
        bookAggRepository.onShelvesBook(bookAgg);
    }

}
