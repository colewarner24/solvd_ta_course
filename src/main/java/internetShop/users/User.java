package internetShop.users;

import internetShop.Identifiable;
import internetShop.exceptions.InvalidUserException;

public class User implements Identifiable {

    private int id;
    private String name;
    private String email;


    public User(int id, String name, String email) throws InvalidUserException {
        if (id < 0) {
            throw new InvalidUserException("Invalid user id");
        }
        if (name == null || name.isEmpty()) {
            throw new InvalidUserException("Invalid user name");
        }
        if (email == null || email.isEmpty()) {
            throw new InvalidUserException("Invalid user email");
        }
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User " + id + ": name=" + name + ", email=" + email + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof User user)) {
            return false;
        }
        return user.getId() == id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
