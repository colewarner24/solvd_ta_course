package internetShop.users;

import internetShop.exceptions.InvalidCredentialException;
import internetShop.exceptions.InvalidUserException;

import java.util.Base64;

// Final class to prevent inheritance and secure the Admin class
public final class Admin extends User implements AutoCloseable {
    private String credentials;
    private static String encodedKey;

    static {
        String passkey = "admin";
        encodedKey = Base64.getEncoder().encodeToString(passkey.getBytes());
    }

    public Admin(int id, String name, String email, String credentials) throws InvalidUserException {
        super(id, name, email);
        if (credentials == null || credentials.isEmpty()) {
            throw new InvalidUserException("Invalid admin credentials");
        }
        this.credentials = credentials;
    }

    public boolean verifyCredentials() throws InvalidCredentialException {
        if (!Base64.getEncoder().encodeToString(credentials.getBytes()).equals(encodedKey)){
            throw new InvalidCredentialException("Invalid admin credentials");
        }
        return true;
    }

    @Override
    public void close() throws Exception {
        credentials = null;
        encodedKey = null;
    }
}