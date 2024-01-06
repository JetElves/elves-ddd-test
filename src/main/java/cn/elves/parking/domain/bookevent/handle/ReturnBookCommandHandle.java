package cn.elves.parking.domain.bookevent.handle;

import cn.elves.parking.domain.bookevent.BookEventAgg;
import cn.elves.parking.domain.bookevent.BookEventAggRepository;
import cn.elves.parking.domain.bookevent.command.OrderBookCommand;

public class ReturnBookCommandHandle {

    private final BookEventAggRepository bookEventAggRepository;



    public ReturnBookCommandHandle(BookEventAggRepository bookEventAggRepository) {
        this.bookEventAggRepository = bookEventAggRepository;

    }


    public void handleReturnBookCommand(OrderBookCommand orderBookCommand){
        BookEventAgg bookEventAgg = bookEventAggRepository.queryBookEventByUserIdAndCode(orderBookCommand.getUserId(), orderBookCommand.getIsbn());
        bookEventAgg.returnBook();
        bookEventAggRepository.saveBookEvent(bookEventAgg);
    }
}
