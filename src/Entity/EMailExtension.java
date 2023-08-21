package Entity;

public enum EMailExtension {
    GMAIL("G-Mail", "gmail.com"),
    OUTLOOK("Outlook", "outlook.com"),
    YAHOO("Yahoo", "yahoo.com");

    private final String name;
    private final String extension;

    EMailExtension(String name, String extension) {
        this.name = name;
        this.extension = extension;
    }

    public String getName() {
        return name;
    }

    public String getExtension() {
        return extension;
    }
}
