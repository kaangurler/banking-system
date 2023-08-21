package Entity;

import java.util.HashMap;
import java.util.Map;

public enum Bank {

    YAPI_KREDI("Yapi Kredi", "00067"),
    AKBANK("Akbank", "00046"),
    BBVA("Garanti BBVA", "00062"),
    QNB("QNB Finansbank", "00111"),
    ING("ING Bank", "00099"),
    IS_BANKASI("Is Bankasi", "00064"),
    ZIRAAT("Ziraat Bankasi", "00010"),
    VAKIFBANK("Vakifbank", "00015"),
    DEUTSCHE("Deutsche Bank", "00115"),
    JP("JP Morgan", "00098");

    public static final double SAME_BANK_FEE = 2.86;
    public static final double DIFFERENT_BANK_FEE = 5.73;
    private final String name;
    private final String bankCode;
    private final Map<Iban, Account> accounts = new HashMap<>();

    Bank(String name, String bankCode) {
        this.name = name;
        this.bankCode = bankCode;
    }

    public String getName() {
        return name;
    }

    public String getBankCode() {
        return bankCode;
    }

    public Map<Iban, Account> getAccounts() {
        return accounts;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
