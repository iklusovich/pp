package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
  // private final static UserService service = new UserServiceImpl();
    private final static UserService service = new UserServiceImpl();
    public static void main(String[] args) {

//        service.createUsersTable();
//        service.saveUser("Ilya1", "klusovich1", (byte) 33);
//        service.saveUser("Ilya2", "klusovich2", (byte) 33);
//        service.saveUser("Ilya3", "klusovich3", (byte) 33);
//        service.saveUser("Ilya4", "klusovich4", (byte) 33);
//        System.out.println(service.getAllUsers());
//        service.cleanUsersTable();
//        service.dropUsersTable();

        service.createUsersTable();
        service.saveUser("lexa", "raz1", (byte) 33);
        service.saveUser("lexa1", "raz2", (byte) 33);
        service.saveUser("lexa2", "raz3", (byte) 33);
        service.saveUser("lexa3", "raz4", (byte) 33);
        System.out.println(service.getAllUsers());
        service.cleanUsersTable();
        service.dropUsersTable();
    }
}
