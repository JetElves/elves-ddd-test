package cn.elves.parking.domain.book.handle;

import cn.elves.parking.domain.book.BookAgg;
import cn.elves.parking.domain.book.BookAggRepository;
import cn.elves.parking.domain.book.command.EnterBookCommand;
import org.springframework.stereotype.Component;

@Component
public class EnterBookCommandHandle {

    private final BookAggRepository bookAggRepository;


    public EnterBookCommandHandle(BookAggRepository bookAggRepository) {
        this.bookAggRepository = bookAggRepository;

    }


    public void handleEnterBookCommand(EnterBookCommand enterBookCommand) {
        BookAgg bookAgg = buildEnterBook(enterBookCommand.getCode(), enterBookCommand.getIsbn());
        bookAggRepository.enterBook(bookAgg);

    }

    private BookAgg buildEnterBook(String code, String isbn) {
        BookAgg bookAgg = new BookAgg();
        bookAgg.setBookStatus("下架");
        bookAgg.setCode(code);
        bookAgg.setIsbn(isbn);
        return bookAgg;
    }


}
