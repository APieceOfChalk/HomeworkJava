import models.Auto;
import models.User;
import services.AutoService;
import services.UserService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        UserService userService = new UserService();
        AutoService autoService = new AutoService();

        User user = new User("Misha",26);
        User user1 = new User("Pasha", 30);
        User user2 = new User("Sasha", 18);
        Auto volvo = new Auto("Volvo", "Silver");
        Auto ferrari = new Auto("Ferrari", "red");
        Auto ford = new Auto("Ford", "black");

        userService.saveUser(user);
        user.addAuto(ferrari);
        user.addAuto(ford);
        user2.addAuto(volvo);
        userService.updateUser(user);

        userService.deleteUser(user1);


        System.out.println(userService.findAllUsers());
        System.out.println(userService.findAutoById(9));
        System.out.println("Выводит пользователя, который владеет данным автомобилем, найденным по id 9:");
        System.out.println(autoService.findUserByAutoId(9));

    }
}