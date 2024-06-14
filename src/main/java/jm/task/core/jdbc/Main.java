package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService service = new UserServiceImpl();
        service.dropUsersTable();
        service.createUsersTable();
        service.saveUser("Ilya2", "klusovich2", (byte) 33);
        service.saveUser("Ilya3", "klusovich2", (byte) 33);
        service.saveUser("Ilya4", "klusovich2", (byte) 33);
        service.removeUserById(0);
        service.getAllUsers();
        service.cleanUsersTable();
    }
}
