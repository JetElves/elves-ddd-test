package cn.elves.parking.domain.bookevent.handle;

import cn.elves.parking.domain.bookevent.BookEventAgg;
import cn.elves.parking.domain.bookevent.BookEventAggRepository;
import cn.elves.parking.domain.bookevent.command.LendOutBookCommand;

public class LendOutBookCommandHandle {

    private final BookEventAggRepository bookEventAggRepository;



    public LendOutBookCommandHandle(BookEventAggRepository bookEventAggRepository) {
        this.bookEventAggRepository = bookEventAggRepository;

    }


    public void handleLendOutBookCommand(LendOutBookCommand lendOutBookCommand){
        BookEventAgg bookEventAgg = bookEventAggRepository.queryBookEventByUserIdAndCode(lendOutBookCommand.getUserId(), lendOutBookCommand.getCode());
        bookEventAgg.lendOutBook();
        bookEventAggRepository.saveBookEvent(bookEventAgg);
    }

}
