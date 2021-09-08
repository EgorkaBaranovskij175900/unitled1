package by.tms.web.controller;

import by.tms.DAO.UserDAO;
import by.tms.DAO.interfaces.UserInterface;
import by.tms.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/test")
public class HomeController {

    private UserDAO userDAO=new UserDAO();

    @GetMapping("/save")
    public  void save(){
        User user=new User("Egor","Egor","Egor");
        userDAO.save(user);

    }
    @GetMapping("/getAll")
    public  void getAll(){
        List<User> user=userDAO.getAll();
        System.out.println(user);

    }
}
