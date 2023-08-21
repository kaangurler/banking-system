package Manager;

import Entity.Account;
import Entity.Bank;
import Entity.Iban;

public class AccountManager {
    private Account account;

    public AccountManager(Account account) {
        this.account = account;
    }

    public void depositMoney(double amountOfMoney) {
        account.setBalance(account.getBalance() + amountOfMoney);
    }

    public void withdrawMoney(double amountOfMoney) {
        if (amountOfMoney <= account.getBalance()) {
            account.setBalance(account.getBalance() - amountOfMoney);
        }
    }

    public void moneyTransferToSameBank(double amountOfMoney, Iban iban) {
        moneyTransfer(amountOfMoney, iban, Bank.SAME_BANK_FEE);
    }

    public void moneyTransferToDifferentBank(double amountOfMoney, Iban iban) {
        moneyTransfer(amountOfMoney, iban, Bank.DIFFERENT_BANK_FEE);
    }

    public void moneyTransfer(double amountOfMoney, Iban iban, double fee) {
        double totalCost = amountOfMoney + fee;
        if (totalCost <= account.getBalance()) {
            Account transferredAccount = this.findAccount(iban);
            transferredAccount.setBalance(transferredAccount.getBalance() + amountOfMoney);
            account.setBalance(account.getBalance() - totalCost);
        }
    }

    private Account findAccount(Iban iban) {
        for (Bank bank : Bank.values()) {
            for (Account acc : bank.getAccounts().values()) {
                System.out.println(acc.getIban());
                System.out.println(iban);
                if (acc.getIban().equals(iban)) {
                    return acc;
                }
            }
        }
        return null;
    }
}
