package Menu;

import Entity.Account;
import Entity.Bank;
import Entity.EMailExtension;
import Manager.LoginManager;

import java.util.Scanner;

public class LoginMenu {
    private final LoginManager loginManager = new LoginManager();
    private final Scanner scanner = new Scanner(System.in);

    public Account loginMenu() {
        while (!loginManager.isBankSuccess()) {
            this.bankChoice();
        }
        while (!loginManager.accountExists()) {
            this.enterEMail();
        }
        while (loginManager.isActive()) {
            if (loginManager.isLoginSuccessful()) {
                System.out.println("You have successfully logged in to your account");
                return loginManager.getAccount();
            }
            this.enterPassword();
        }
        if (!loginManager.isLoginSuccessful()) {
            System.out.println("Login failed");
        }
        return null;
    }

    private void enterPassword() {
        String attemptStatus = loginManager.getLoginAttemptLeft() != 1 ? "You have " +
                loginManager.getLoginAttemptLeft() + " attempts left" : "You have " +
                loginManager.getLoginAttemptLeft() + " attempt left";
        System.out.println(attemptStatus);
        System.out.print("-> Enter password: ");
        loginManager.loginAttempt(scanner.next());
    }

    private void enterEMail() {
        System.out.print("-> Enter e mail address (without an extension): ");
        String value = scanner.next();
        int order = 1;
        for (EMailExtension eMailExtension : EMailExtension.values()) {
            System.out.println(order + ". " + eMailExtension);
            order++;
        }
        loginManager.setEMail(value, scanner.nextInt());
        loginManager.chooseAccount();
        if (!loginManager.accountExists()) {
            System.out.println("No account associated with this email found");
        }
    }

    private void bankChoice() {
        System.out.println("----------------");
        int order = 1;
        for (Bank bank : Bank.values()) {
            System.out.println(order + ". " + bank);
            order++;
        }
        System.out.print("-> Choose a bank: ");
        loginManager.setBank(scanner.nextInt());
        if (!loginManager.isBankSuccess()) {
            System.out.println("Invalid option");
        }
    }
}
