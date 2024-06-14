package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
   private final static UserService service = new UserServiceImpl();
    public static void main(String[] args) {

        service.createUsersTable();
        service.saveUser("Ilya1", "klusovich1", (byte) 33);
        service.saveUser("Ilya2", "klusovich2", (byte) 33);
        service.saveUser("Ilya3", "klusovich3", (byte) 33);
        service.saveUser("Ilya4", "klusovich4", (byte) 33);
        System.out.println(service.getAllUsers());
        service.cleanUsersTable();
        service.dropUsersTable();
    }
}
