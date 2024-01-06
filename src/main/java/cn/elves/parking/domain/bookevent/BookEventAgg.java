package cn.elves.parking.domain.bookevent;

import java.time.LocalDateTime;

public class BookEventAgg {


    private String userId;

    private String code;

    private String bookStatus;

    private Integer bookStocks;

    private LocalDateTime happenedTime;

    private String status;

    private Integer curHoldBookCount;

    public void orderBook() {
        if (isOffShelves()) {
            throw new RuntimeException("该书已下架");
        }
        if (!hasFreeBook()) {
            throw new RuntimeException("该书已经被定完");
        }
        if (isOverHold()) {
            throw new RuntimeException("已经借用了三本书");
        }
        this.Order();

    }

    public void getBook() {
        if (isOffShelves()) {
            throw new RuntimeException("该书已下架");
        }
        if (!isOrdered()) {
            throw new RuntimeException("没有预定该书 无法领取");
        }
        this.get();
    }

    public void lendOutBook() {
        if (isOffShelves()) {
            throw new RuntimeException("该书已下架");
        }
        if (!isLendOut()) {
            throw new RuntimeException("该书已被借出");
        }
        this.lendOut();
    }

    public void returnBookTimeOut() {
       this.returnTimeOut();
    }

    public void returnBook() {
        this.returnBack();
        if(isExpire()){
            //publish event;
        }
    }

    public void getBookTimeOut() {
        this.getTimeOut();
    }

    public void LostBook() {
        this.lost();
    }

    private void lost() {
        setStatus("被遗失");
        setHappenedTime(LocalDateTime.now());

        //publish event; lost book;
    }

    private void getTimeOut() {
        setStatus("空闲");
        setHappenedTime(LocalDateTime.now());
        setBookStocks(getBookStocks() + 1);
        setCurHoldBookCount(getCurHoldBookCount() - 1);
    }

    private void returnBack() {
        setStatus("空闲");
        setHappenedTime(LocalDateTime.now());
        setCurHoldBookCount(getCurHoldBookCount() - 1);
    }

    private void returnTimeOut() {
        setBookStatus("已遗失");
        setHappenedTime(LocalDateTime.now());
    }

    private void lendOut() {
        setBookStatus("已借出");
        setHappenedTime(LocalDateTime.now());
        setCurHoldBookCount(getCurHoldBookCount() + 1);
    }

    private void get() {
        setBookStatus("已被领取");
        setHappenedTime(LocalDateTime.now());
        setCurHoldBookCount(getCurHoldBookCount() + 1);
    }

    private void Order() {
        setCurHoldBookCount(getCurHoldBookCount() + 1);
        setBookStatus("被预订");
        setBookStocks(getBookStocks() - 1);
        setHappenedTime(LocalDateTime.now());
    }

    private Boolean isExpire() {
        LocalDateTime localDateTime = getHappenedTime().plusDays(30L);
        return LocalDateTime.now().isAfter(localDateTime);
    }


    private Boolean hasFreeBook() {
        return bookStocks != 0;
    }

    private Boolean isOrdered() {
        return "被预订".equals(getStatus());
    }

    private Boolean isLendOut() {
        return "被借出".equals(getStatus());
    }

    private Boolean isGotten() {
        return null;
    }

    private Boolean isReturn() {
        return null;
    }

    private Boolean isLost() {
        return null;
    }

    private Boolean isOverHold() {
        return curHoldBookCount >= 3;
    }

    private Boolean isOnShelves() {
        return null;
    }

    private Boolean isOffShelves() {
        return "已下架".equals(bookStatus);
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public Integer getBookStocks() {
        return bookStocks;
    }

    public void setBookStocks(Integer bookStocks) {
        this.bookStocks = bookStocks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getHappenedTime() {
        return happenedTime;
    }

    public void setHappenedTime(LocalDateTime happenedTime) {
        this.happenedTime = happenedTime;
    }

    public Integer getCurHoldBookCount() {
        return curHoldBookCount;
    }

    public void setCurHoldBookCount(Integer curHoldBookCount) {
        this.curHoldBookCount = curHoldBookCount;
    }



}
