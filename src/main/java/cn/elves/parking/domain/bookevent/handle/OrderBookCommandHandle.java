package cn.elves.parking.domain.bookevent.handle;

import cn.elves.parking.domain.bookevent.BookEventAgg;
import cn.elves.parking.domain.bookevent.BookEventAggRepository;
import cn.elves.parking.domain.bookevent.command.OrderBookCommand;
import org.springframework.stereotype.Component;

@Component
public class OrderBookCommandHandle {

    private final BookEventAggRepository bookEventAggRepository;



    public OrderBookCommandHandle(BookEventAggRepository bookEventAggRepository) {
        this.bookEventAggRepository = bookEventAggRepository;

    }


    public void handleOrderCommand(OrderBookCommand orderBookCommand){
        BookEventAgg bookEventAgg = bookEventAggRepository.queryBookEventByUserIdAndISBN(orderBookCommand.getUserId(), orderBookCommand.getIsbn());
        bookEventAgg.orderBook();
        bookEventAggRepository.saveBookEvent(bookEventAgg);
    }
}
