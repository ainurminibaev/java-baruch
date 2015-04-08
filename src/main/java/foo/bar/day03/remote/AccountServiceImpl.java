package foo.bar.day03.remote;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// the implementation doing nothing at the moment
public class AccountServiceImpl implements AccountService {

    List<Account> accounts = Collections.synchronizedList(new ArrayList<Account>());

    public void insertAccount(Account acc) {
        // do something...
        System.out.println("INSERT");
        accounts.add(acc);
    }

    public List<Account> getAccounts(String name) {
        // do something...
        System.out.println("GET ACCOUNT");
        return accounts;
    }

}