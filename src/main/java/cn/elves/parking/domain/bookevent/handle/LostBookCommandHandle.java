package cn.elves.parking.domain.bookevent.handle;

import cn.elves.parking.domain.bookevent.BookEventAgg;
import cn.elves.parking.domain.bookevent.BookEventAggRepository;
import cn.elves.parking.domain.bookevent.command.LostBookCommand;

public class LostBookCommandHandle {

    private final BookEventAggRepository bookEventAggRepository;



    public LostBookCommandHandle(BookEventAggRepository bookEventAggRepository) {
        this.bookEventAggRepository = bookEventAggRepository;

    }


    public void handleLostBookCommand(LostBookCommand lostBookCommand){
        BookEventAgg bookEventAgg = bookEventAggRepository.queryBookEventByUserIdAndCode(lostBookCommand.getUserId(), lostBookCommand.getCode());
        bookEventAgg.LostBook();
        bookEventAggRepository.saveBookEvent(bookEventAgg);
    }
}
