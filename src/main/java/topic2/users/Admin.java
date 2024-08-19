package topic2.users;

public class Admin extends User {
    private String credentials;

    public Admin(int id, String name, String email, String credentials) {
        super(id, name, email);
        this.credentials = credentials;
    }

    public boolean verifyCredentials() {
        return "admin".equals(credentials);
    }

}
