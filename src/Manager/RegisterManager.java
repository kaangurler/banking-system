package Manager;

import Entity.*;
import Utility.IbanCreator;
import Utility.RegisterCriteriaChecker;

public class RegisterManager {

    private Bank bank;
    private String name;
    private int age;
    private EMail eMail;
    private String password;

    public void createAccount() {
        Iban iban = IbanCreator.generateIban(bank);
        bank.getAccounts().put(iban, new Account(bank, name, age, eMail, password, iban));
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

    public void setName(String name) {
        if (RegisterCriteriaChecker.checkNameCriteria(name)) {
            this.name = name;
        }
    }

    public void setAge(int age) {
        if (RegisterCriteriaChecker.checkAgeCriteria(age)) {
            this.age = age;
        }
    }

    public void setEMail(String value, int extension) {
        EMail tempMail = null;
        switch (extension) {
            case 1 -> tempMail = RegisterCriteriaChecker.checkEMailCriteria(value) ? new EMail(value, EMailExtension.GMAIL) : null;
            case 2 -> tempMail = RegisterCriteriaChecker.checkEMailCriteria(value) ? new EMail(value, EMailExtension.OUTLOOK) : null;
            case 3 -> tempMail = RegisterCriteriaChecker.checkEMailCriteria(value) ? new EMail(value, EMailExtension.YAHOO) : null;
        }
        if (tempMail != null) {
            if (!RegisterCriteriaChecker.checkMailExists(bank, tempMail)) {
                eMail = tempMail;
            }
        }
    }

    public void setPassword(String password) {
        if (RegisterCriteriaChecker.checkPasswordCriteria(password)) {
            this.password = password;
        }
    }

    public boolean isBankSuccess() {
        if (this.bank != null) {
            return true;
        }
        return false;
    }

    public boolean isNameSuccess() {
        if (this.name != null) {
            return true;
        }
        return false;
    }

    public boolean isAgeSuccess() {
        if (this.age != 0) {
            return true;
        }
        return false;
    }

    public boolean isEMailSuccess() {
        if (this.eMail != null) {
            return true;
        }
        return false;
    }

    public boolean isPasswordSuccess() {
        if (this.password != null) {
            return true;
        }
        return false;
    }
}
