package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("Petr", "Petrov", "petrov@gmail.com");
      User user2 = new User("Vasya", "Vasilkov", "petrov@gmail.com");
      User user3 = new User("Sveta", "Evseeva", "petrov@gmail.com");
      User user4 = new User("Nadya", "Korneeva", "petrov@gmail.com");

      user1.setCar(new Car("девятка", 2109));
      user2.setCar(new Car("шестерка", 2106));
      user3.setCar(new Car("копейка", 2101));
      user4.setCar(new Car("чепырка", 2114));

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = "+user.getCar());
         System.out.println();
      }

      System.out.println(userService.getByCar("копейка", 2101));

      context.close();
   }
}
