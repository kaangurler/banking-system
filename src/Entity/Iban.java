package Entity;

public record Iban(String checkDigits, String bankCode, String reservedField, String bankAccountNo) {

    @Override
    public String toString() {
        return "TR" + checkDigits + bankCode + reservedField + bankAccountNo;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("");
        if (this.toString().equals(((Iban) obj).toString())) {
            return true;
        }
        return false;
    }
}
