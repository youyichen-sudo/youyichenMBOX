package ERyder;

import java.util.ArrayList;

public class UserService {
    private ArrayList<RegisteredUsers> registeredUsers = new ArrayList<>();

    public void addUser(RegisteredUsers user) {
        registeredUsers.add(user);
    }

    public ArrayList<RegisteredUsers> getAllUsers() {
        return registeredUsers;
    }

    public boolean removeUserByEmail(String email) {
        for (int i = 0; i < registeredUsers.size(); i++) {
            if (registeredUsers.get(i).getEmailAddress().equals(email)) {
                registeredUsers.remove(i);
                return true;
            }
        }
        return false;
    }

    public RegisteredUsers findUserByEmail(String email) {
        for (RegisteredUsers user : registeredUsers) {
            if (user.getEmailAddress().equals(email)) {
                return user;
            }
        }
        return null;
    }
}