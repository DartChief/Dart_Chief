package springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import springmvc.model.Order;
import springmvc.model.User;
import springmvc.repositories.OrderRepository;
import springmvc.repositories.UserRepository;
import springmvc.validators.OrderValidator;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderValidator validator;

    @RequestMapping(value = "/createOrder", method = RequestMethod.GET)
    public ModelAndView createOrder(ModelAndView modelAndView) throws SQLException {
        Order order = new Order();
        modelAndView.addObject("order", order);
        modelAndView.setViewName("OrderForm");
        modelAndView.addObject("userList", userRepository.showAll());
        return modelAndView;
    }

    @RequestMapping(value = "/listOrders")
    public ModelAndView listOrders(ModelAndView modelAndView) throws SQLException {
        List<Order> orders = orderRepository.showAll();
        modelAndView.addObject("orders", orders);
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        for (User user : userRepository.showAll()) {
            map.put(user.getId(), user.getName());
        }
        modelAndView.addObject("map", map);
        modelAndView.setViewName("listOrders");
        System.out.println("Order List");
        return modelAndView;

    }

    @RequestMapping(value = "/updateOrder", method = RequestMethod.GET)
    public ModelAndView updateOrder(HttpServletRequest request) throws SQLException {
        int orderId = Integer.parseInt(request.getParameter("id"));
        Order order = orderRepository.getOrder(orderId);
        ModelAndView model = new ModelAndView("OrderForm");
        model.addObject("userList", userRepository.showAll());
        model.addObject("order", order);
        System.out.println("Order Update");
        return model;

    }

    @RequestMapping(value = "/deleteOrder", method = RequestMethod.GET)
    public ModelAndView deleteOrder(HttpServletRequest request) throws SQLException {
        int orderId = Integer.parseInt(request.getParameter("id"));
        orderRepository.delete(orderId);
        System.out.println("Order Delete");
        return new ModelAndView("redirect:/listOrders");
    }


    @RequestMapping(value = "/saveOrder", method = RequestMethod.POST)
    public ModelAndView saveOrder(ModelAndView modelAndView, @ModelAttribute("order") @Valid Order order, BindingResult result) throws SQLException {
        validator.validate(order, result);
        if (result.hasErrors()) {
            modelAndView.addObject("order", order);
            modelAndView.setViewName("OrderForm");
            modelAndView.addObject("userList", userRepository.showAll());
            return modelAndView;
        }
        if (order.getId() > 0) {
            this.orderRepository.update(order);
        } else {
            this.orderRepository.addOrder(order);
        }
        return new ModelAndView("redirect:/listOrders");
    }
}
