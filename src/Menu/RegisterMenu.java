package Menu;

import Entity.Bank;
import Entity.EMailExtension;
import Manager.RegisterManager;

import java.util.Scanner;

public class RegisterMenu {
    private RegisterManager registerManager = new RegisterManager();
    private final Scanner scanner = new Scanner(System.in);

    public void registerMenu() {
        System.out.println("---WELCOME TO THE REGISTER MENU---");
        while (!registerManager.isBankSuccess()) {
            this.bankChoice();
        }
        while (!registerManager.isNameSuccess()) {
            this.enterName();
        }
        while (!registerManager.isAgeSuccess()) {
            this.enterAge();
        }
        while (!registerManager.isEMailSuccess()) {
            this.enterEMail();
        }
        while (!registerManager.isPasswordSuccess()) {
            this.enterPassword();
        }
        registerManager.createAccount();
        System.out.println("Account created successfully");
    }

    private void bankChoice() {
        int order = 1;
        System.out.println("----------------");
        for (Bank bank : Bank.values()) {
            System.out.println(order + ". " + bank);
            order++;
        }
        System.out.print("-> Choose a bank: ");
        registerManager.setBank(scanner.nextInt());
        if (registerManager.isBankSuccess()) {
            System.out.println("Successful");
        } else {
            System.out.println("Invalid option");
        }
    }

    private void enterName() {
        System.out.print("-> Enter your first name (Min 2-Max 15 Letters): ");
        registerManager.setName(scanner.next());
        if (registerManager.isNameSuccess()) {
            System.out.println("Successful");
        } else {
            System.out.println("You should provide a name with the length between 2-15");
        }
    }

    private void enterAge() {
        System.out.print("-> Enter your age (Min:18 - Max 120): ");
        registerManager.setAge(scanner.nextInt());
        if (registerManager.isAgeSuccess()) {
            System.out.println("Successful");
        } else {
            System.out.println("Age must be within the range 18-120");
        }
    }

    private void enterEMail() {
        System.out.print("-> Enter your e mail address (without an extension): ");
        String value = scanner.next();
        int order = 1;
        for (EMailExtension eMailExtension : EMailExtension.values()) {
            System.out.println(order + ". " + eMailExtension);
            order++;
        }
        registerManager.setEMail(value, scanner.nextInt());
        if (registerManager.isEMailSuccess()) {
            System.out.println("Successful");
        } else {
            System.out.println("You must have at least 1 letter in e mail/ Existing email entered");
        }
    }

    private void enterPassword() {
        System.out.print("-> Enter your password (Min 1 Uppercase, Lowercase Letter, and a number): ");
        registerManager.setPassword(scanner.next());
        if (registerManager.isPasswordSuccess()) {
            System.out.println("Successful");
        } else {
            System.out.println("The password you entered does not match with the criteria");
        }
    }
}
