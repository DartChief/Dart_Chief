package springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import springmvc.model.User;
import springmvc.repositories.UserRepository;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value="/createUser", method=RequestMethod.GET)
    public ModelAndView createUser(ModelAndView modelAndView) throws SQLException {
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("UserForm");
        return modelAndView;
    }

    @RequestMapping(value = "/")
    public ModelAndView listUsers(ModelAndView modelAndView) throws SQLException {
        modelAndView.addObject("users", userRepository.showAll());
        modelAndView.setViewName("home");
        System.out.println("User List");
        return modelAndView;

    }

    @RequestMapping(value="/updateUser", method=RequestMethod.GET)
    public ModelAndView updateUser(HttpServletRequest request) throws SQLException {
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = userRepository.getUser(userId);
        ModelAndView model = new ModelAndView("UserForm");
        model.addObject("user", user);
        System.out.println("User Update");
        return model;

    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public ModelAndView deleteUser(HttpServletRequest request) throws SQLException {
        int userId = Integer.parseInt(request.getParameter("id"));
        userRepository.delete(userId);
        System.out.println("User Delete");
        return new ModelAndView("redirect:/");
    }


    @RequestMapping(value="/saveUser", method=RequestMethod.POST)
    public ModelAndView saveUser(@ModelAttribute User user) throws SQLException {
        if(user.getId() > 0){
            this.userRepository.update(user);
        } else {
            this.userRepository.addUser(user);
        }
        return new ModelAndView("redirect:/");
    }
}
