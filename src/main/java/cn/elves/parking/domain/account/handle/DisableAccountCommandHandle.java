package cn.elves.parking.domain.account.handle;

import cn.elves.parking.domain.account.AccountAgg;
import cn.elves.parking.domain.account.AccountAggRepository;
import cn.elves.parking.domain.account.command.DisableAccountCommand;
import org.springframework.stereotype.Component;

@Component
public class DisableAccountCommandHandle {

    private final AccountAggRepository accountAggRepository;


    public DisableAccountCommandHandle(AccountAggRepository accountAggRepository) {
        this.accountAggRepository = accountAggRepository;
    }

    public void handleEnableAccountCommand(DisableAccountCommand disableAccountCommand) {
        AccountAgg accountAgg = accountAggRepository.queryAccountAggByAccount(disableAccountCommand.getDisAbleAccount());
        accountAgg.disableAccount();
        disAbleAccount(accountAgg);
    }

    private void disAbleAccount(AccountAgg accountAgg){
        accountAggRepository.updateAccount(accountAgg);
    }
}
