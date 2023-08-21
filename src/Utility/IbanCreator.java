package Utility;

import Entity.Bank;
import Entity.Iban;

public class IbanCreator {

    public static Iban generateIban(Bank bank) {
        return new Iban(generateCheckDigits(), bank.getBankCode(), "0", generateBankAccountNo());
    }

    private static String generateBankAccountNo() {
        String accountNo = "";
        for (int i = 0; i < 16; i++) {
            accountNo += (int) (Math.random() * 10);
        }
        return accountNo;
    }

    private static String generateCheckDigits() {
        String checkDigits = "";
        for (int i = 0; i < 2; i++) {
            checkDigits += (int) (Math.random() * 10);
        }
        return checkDigits;
    }

    public static Iban generateIbanFromStr(String ibanStr) {
        if (ibanStr.length() == 26) {
            return new Iban(ibanStr.substring(2, 4), ibanStr.substring(4, 9), ibanStr.substring(9, 10),ibanStr.substring(10));
        }
        return null;
    }
}
