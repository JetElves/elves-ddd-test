package cn.elves.parking.domain.book;

public class BookAgg {

    private String isbn;

    private String code;

    private String bookStatus;

    public void offShelvesBook() {
        if (isOffShelves()) {
            throw new RuntimeException("该书已经下架");
        }
        this.offShelves();
    }

    public void onShelvesBook() {
        if (isOnShelves()) {
            throw new RuntimeException("该书已经上架");
        }
        this.onShelves();
    }

    private void onShelves() {
        setBookStatus("上架");
    }

    private void offShelves() {
        setBookStatus("下架");
    }

    private Boolean isOnShelves() {
        return "上架".equals(bookStatus);
    }

    private Boolean isOffShelves() {
        return "下架".equals(bookStatus);
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(String bookStatus) {
        this.bookStatus = bookStatus;
    }



}
