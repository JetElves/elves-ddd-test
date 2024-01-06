package cn.elves.parking.domain.account;

public interface AccountAggRepository {
    AccountAgg queryAccountAggByAccount(String account);

    void updateAccount(AccountAgg accountAgg);
}
