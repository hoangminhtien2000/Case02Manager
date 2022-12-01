package sort;

import model.Account;

import java.util.Comparator;

public class SortAccount_ID implements Comparator<Account> {
    @Override
    public int compare(Account account1, Account account2) {
        return  account1.getId() - account2.getId();
    }
}