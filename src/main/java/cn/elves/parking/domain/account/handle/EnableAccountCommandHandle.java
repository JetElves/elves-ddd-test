package cn.elves.parking.domain.account.handle;

import cn.elves.parking.domain.account.AccountAgg;
import cn.elves.parking.domain.account.AccountAggRepository;
import cn.elves.parking.domain.account.command.EnableAccountCommand;
import org.springframework.stereotype.Component;

@Component
public class EnableAccountCommandHandle {

    private final AccountAggRepository accountAggRepository;


    public EnableAccountCommandHandle(AccountAggRepository accountAggRepository) {
        this.accountAggRepository = accountAggRepository;
    }

    public void handleEnableAccountCommand(EnableAccountCommand enableAccountCommand) {
        AccountAgg accountAgg = accountAggRepository.queryAccountAggByAccount(enableAccountCommand.getEnAbleAccount());
        accountAgg.enableAccount();
        enAbleAccount(accountAgg);
    }

    private void enAbleAccount(AccountAgg accountAgg){
        accountAggRepository.updateAccount(accountAgg);
    }

}
