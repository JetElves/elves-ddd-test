package cn.elves.parking.domain.bookevent.handle;

import cn.elves.parking.domain.bookevent.BookEventAgg;
import cn.elves.parking.domain.bookevent.BookEventAggRepository;
import cn.elves.parking.domain.bookevent.command.GetBookCommand;
import org.springframework.stereotype.Component;

@Component
public class GetBookCommandHandle {

    private final BookEventAggRepository bookEventAggRepository;



    public GetBookCommandHandle(BookEventAggRepository bookEventAggRepository) {
        this.bookEventAggRepository = bookEventAggRepository;

    }


    public void handleOrderCommand(GetBookCommand getBookCommand){
        BookEventAgg bookEventAgg = bookEventAggRepository.queryBookEventByUserIdAndCode(getBookCommand.getUserId(), getBookCommand.getCode());
        bookEventAgg.getBook();
        bookEventAggRepository.saveBookEvent(bookEventAgg);
    }
}
