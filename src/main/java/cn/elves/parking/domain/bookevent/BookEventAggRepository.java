package cn.elves.parking.domain.bookevent;

public interface BookEventAggRepository {
    BookEventAgg queryBookEventByUserIdAndISBN(String userId, String isbn);

    void saveBookEvent(BookEventAgg bookEventAgg);

    BookEventAgg queryBookEventByUserIdAndCode(String userId, String code);
}
