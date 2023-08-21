package Entity;

import java.util.List;

public class Account {

    private final Bank bank;
    private final String name;
    private final int age;
    private final Iban iban;
    private EMail eMail;
    private String password;
    private double balance;
    private boolean loggedIn;

    public Account(Bank bank, String name, int age, EMail eMail, String password, Iban iban) {
        this.bank = bank;
        this.name = name;
        this.age = age;
        this.eMail = eMail;
        this.password = password;
        this.iban = iban;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public Bank getBank() {
        return bank;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public EMail getEMail() {
        return eMail;
    }

    public Iban getIban() {
        return iban;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }


    @Override
    public String toString() {
        return "Name: " + name + " - Age: " + age + " - Email: " + eMail + " - Iban: " + iban + " - Bank: " + bank;
    }

    @Override
    public boolean equals(Object obj) {
        if (this.iban.equals(((Account) obj).getIban())) {
            return true;
        }
        return false;
    }
}
