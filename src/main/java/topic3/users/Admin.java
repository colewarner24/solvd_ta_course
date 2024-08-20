package topic3.users;

import java.util.Base64;

// Final class to prevent inheritance and secure the Admin class
public final class Admin extends User {
    private String credentials;
    private static String encodedKey;

    static {
        System.out.println("Creating admin credentials");
        String passkey = "admin";
        encodedKey = Base64.getEncoder().encodeToString(passkey.getBytes());
    }

    public Admin(int id, String name, String email, String credentials) {
        super(id, name, email);
        this.credentials = credentials;
    }

    public boolean verifyCredentials() {
        return Base64.getEncoder().encodeToString(credentials.getBytes()).equals(encodedKey);
    }
}