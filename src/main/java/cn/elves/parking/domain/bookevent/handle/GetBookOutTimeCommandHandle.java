package cn.elves.parking.domain.bookevent.handle;

import cn.elves.parking.domain.bookevent.BookEventAgg;
import cn.elves.parking.domain.bookevent.BookEventAggRepository;
import cn.elves.parking.domain.bookevent.command.GetBookOutTimeCommand;

public class GetBookOutTimeCommandHandle {

    private final BookEventAggRepository bookEventAggRepository;



    public GetBookOutTimeCommandHandle(BookEventAggRepository bookEventAggRepository) {
        this.bookEventAggRepository = bookEventAggRepository;

    }


    public void handleOrderCommand(GetBookOutTimeCommand getBookOutTimeCommand){
        BookEventAgg bookEventAgg = bookEventAggRepository.queryBookEventByUserIdAndCode(getBookOutTimeCommand.getUserId(), getBookOutTimeCommand.getCode());
        bookEventAgg.getBookTimeOut();
        bookEventAggRepository.saveBookEvent(bookEventAgg);
    }
}
