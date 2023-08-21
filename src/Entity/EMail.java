package Entity;

public record EMail(String address, EMailExtension eMailExtension) {

    @Override
    public String toString() {
        return address + "@" + eMailExtension.getExtension();
    }

    @Override
    public boolean equals(Object obj) {
        if (address.equals(((EMail) obj).address) && eMailExtension.equals(((EMail) obj).eMailExtension)) {
            return true;
        }
        return false;
    }
}
