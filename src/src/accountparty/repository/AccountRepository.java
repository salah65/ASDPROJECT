package accountparty.repository;

import accountparty.account.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AccountRepository {

    private static final List<Account> ACCOUNT_DB = new ArrayList<>();
    public void save(Account account) {
        ACCOUNT_DB.add(account);
    }

    public Account findByAccountNumber(String accountNumber) {
        return ACCOUNT_DB.stream().filter(account ->
                Objects.equals(account.getAccountNumber(), accountNumber))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));
    }
    public List<Account> getAllAccounts() {
        return new ArrayList<>(ACCOUNT_DB);
    }
    public void update(Account account) {
        int index = ACCOUNT_DB.indexOf(findByAccountNumber(account.getAccountNumber()));
        if (index != -1) {
            ACCOUNT_DB.set(index, account);
        } else {
            throw new IllegalArgumentException("Account not found for update");
        }
    }
}
