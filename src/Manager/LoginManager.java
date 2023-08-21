package Manager;

import Entity.Account;
import Entity.Bank;
import Entity.EMail;
import Entity.EMailExtension;

public class LoginManager {
    private int loginAttemptLeft = 3;
    private boolean active = true;
    private Bank bank;
    private EMail eMail;
    private Account account;

    public Account getAccount() {
        return account;
    }

    public boolean isLoginSuccessful() {
        return account.isLoggedIn();
    }

    public void setBank(int choice) {
        switch (choice) {
            case 1 -> this.bank = Bank.YAPI_KREDI;
            case 2 -> this.bank = Bank.AKBANK;
            case 3 -> this.bank = Bank.BBVA;
            case 4 -> this.bank = Bank.QNB;
            case 5 -> this.bank = Bank.ING;
            case 6 -> this.bank = Bank.IS_BANKASI;
            case 7 -> this.bank = Bank.ZIRAAT;
            case 8 -> this.bank = Bank.VAKIFBANK;
            case 9 -> this.bank = Bank.DEUTSCHE;
            case 10 -> this.bank = Bank.JP;
        }
    }

    public void setEMail(String value, int choice) {
        switch (choice) {
            case 1 -> this.eMail = new EMail(value, EMailExtension.GMAIL);
            case 2 -> this.eMail = new EMail(value, EMailExtension.OUTLOOK);
            case 3 -> this.eMail = new EMail(value, EMailExtension.YAHOO);
        }
    }

    public boolean isActive() {
        return active;
    }

    public boolean accountExists() {
        return this.account != null;
    }

    public boolean isBankSuccess() {
        return this.bank != null;
    }

    public int getLoginAttemptLeft() {
        return loginAttemptLeft;
    }

    public void loginAttempt(String password) {
        if (this.passwordMatch(password)) {
            this.account.setLoggedIn(true);
        } else {
            loginAttemptLeft--;
            if (loginAttemptLeft == 0) {
                this.active = false;
            }
        }
    }

    public void chooseAccount() {
        for (Account account : this.bank.getAccounts().values()) {
            if (account.getEMail().equals(eMail)) {
                this.account = account;
            }
        }
    }

    private boolean passwordMatch(String password) {
        return account.getPassword().equals(password);
    }
}