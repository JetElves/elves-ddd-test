package cn.elves.parking.domain.book;

public interface BookAggRepository {


    void enterBook(BookAgg bookAgg);

    BookAgg queryBookByCode(String code);

    void offShelvesBook(BookAgg bookAgg);

    void onShelvesBook(BookAgg bookAgg);
}
