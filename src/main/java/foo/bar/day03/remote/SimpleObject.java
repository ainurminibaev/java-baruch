package foo.bar.day03.remote;

import java.util.List;

public class SimpleObject {

    private AccountService accountService;

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    // additional methods using the accountService

    public List<Account> call() {
        return accountService.getAccounts("sfdf");
    }

    public void insert() {
        accountService.insertAccount(new Account());
    }

}