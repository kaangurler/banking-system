package Menu;

import Entity.Account;

import java.util.Scanner;

public class BankMenu {

    private Scanner scanner = new Scanner(System.in);

    public void menu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Login");
            System.out.println("2. Open a Bank Account");
            System.out.println("3. Exit");
            switch (scanner.nextInt()) {
                case 1 -> {
                    Account account = new LoginMenu().loginMenu();
                    if (account != null) {
                        new AccountMenu(account).accountMenu();
                    }
                }
                case 2 -> new RegisterMenu().registerMenu();
                case 3 -> exit = true;
                default -> System.out.println("Please enter a valid choice");
            }
        }
    }


}
