package cn.elves.parking.domain.account;

public class AccountAgg {

    private String userId;

    private String accountStatus;

    private String lostCount;

    public void enableAccount() {
        if(isEnAble()){
            throw new RuntimeException("该账户已在启用状态");
        }
        this.enable();
    }

    public void disableAccount() {
        if(isDisAble()){
            throw new RuntimeException("该账户已在禁用状态");
        }
        this.disable();
    }

    private void disable() {
        setAccountStatus("禁用");
    }

    private void enable() {
        setAccountStatus("启用");
    }

    private Boolean isDisAble(){
        return "禁用".equals(getAccountStatus());
    }

    private Boolean isEnAble(){
        return "启用".equals(getAccountStatus());
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getLostCount() {
        return lostCount;
    }

    public void setLostCount(String lostCount) {
        this.lostCount = lostCount;
    }


}
