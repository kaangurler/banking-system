package Utility;

import Entity.Account;
import Entity.Bank;
import Entity.EMail;

public class RegisterCriteriaChecker {

    public static boolean checkNameCriteria(String name) {
        return name.length() >= 2 && name.length() <= 15;
    }

    public static boolean checkAgeCriteria(int age) {
        return age >= 18 && age <= 120;
    }

    public static boolean checkPasswordCriteria(String password) {
        boolean lowercase = false, uppercase = false, numerical = false;
        for (Character chr : password.toCharArray()) {
            lowercase = (lowercase == true) ? true : Character.isLowerCase(chr);
            uppercase = (uppercase == true) ? true : Character.isUpperCase(chr);
            numerical = (numerical == true) ? true : Character.isDigit(chr);
            if (lowercase && uppercase && numerical) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkEMailCriteria(String value) {
        return value.length() >= 1;
    }

    public static boolean checkMailExists(Bank bank, EMail eMail) {
        for (Account account : bank.getAccounts().values()) {
            if (account.getEMail().equals(eMail)) {
                return true;
            }
        }
        return false;
    }
}
