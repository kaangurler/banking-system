package Menu;

import Entity.Account;
import Entity.Bank;
import Manager.AccountManager;
import Utility.IbanCreator;

import java.util.Scanner;

public class AccountMenu {
    private Account account;
    private final AccountManager accountManager;
    private final Scanner scanner = new Scanner(System.in);

    public AccountMenu(Account account) {
        this.accountManager = new AccountManager(account);
        this.account = account;
    }

    public void accountMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println(account);
            System.out.println("1. Deposit\n2. Withdraw\n3. Transfer (Same Bank)\n4. Transfer (Different Bank)\n5. Display All Accounts\nExit");
            switch (scanner.nextInt()) {
                case 1 -> {
                    System.out.print("Amount of money( in TL): ");
                    accountManager.depositMoney(scanner.nextDouble());
                }
                case 2 -> {
                    System.out.print("Amount of money( in TL): ");
                    accountManager.withdrawMoney(scanner.nextDouble());
                }
                case 3 -> {
                    System.out.print("Amount of money( in TL)");
                    double amount = scanner.nextDouble();
                    System.out.println("Iban to sent money: ");
                    String ibanStr = scanner.next();
                    accountManager.moneyTransferToSameBank(amount, IbanCreator.generateIbanFromStr(ibanStr));
                }
                case 4 -> {
                    System.out.print("Amount of money( in TL)");
                    double amount = scanner.nextDouble();
                    System.out.println("Iban to sent money: ");
                    String ibanStr = scanner.next();
                    accountManager.moneyTransferToDifferentBank(amount, IbanCreator.generateIbanFromStr(ibanStr));
                }
                case 5 -> displayAccounts();
                default -> exit = true;
            }
            System.out.println("Money ----> " + account.getBalance());
        }
    }

    private void displayAccounts() {
        for (Bank bank : Bank.values()) {
            for (Account acc : bank.getAccounts().values()) {
                System.out.println("Name: " + acc.getName().substring(0, 2) + "***" + " - Bank: " + acc.getBank() + " - IBAN: " + acc.getIban());
            }
        }
    }
}
