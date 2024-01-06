package cn.elves.parking.domain.bookevent.handle;

import cn.elves.parking.domain.bookevent.BookEventAgg;
import cn.elves.parking.domain.bookevent.BookEventAggRepository;
import cn.elves.parking.domain.bookevent.command.ReturnBookOutTimeCommand;
import org.springframework.stereotype.Component;

@Component
public class ReturnBookOutTimeCommandHandle {


    private final BookEventAggRepository bookEventAggRepository;



    public ReturnBookOutTimeCommandHandle(BookEventAggRepository bookEventAggRepository) {
        this.bookEventAggRepository = bookEventAggRepository;

    }


    public void handleReturnBookOutTimeCommand(ReturnBookOutTimeCommand returnBookOutTimeCommand){
        BookEventAgg bookEventAgg = bookEventAggRepository.queryBookEventByUserIdAndCode(returnBookOutTimeCommand.getUserId(), returnBookOutTimeCommand.getCode());
        bookEventAgg.returnBookTimeOut();
        bookEventAggRepository.saveBookEvent(bookEventAgg);
    }
}
