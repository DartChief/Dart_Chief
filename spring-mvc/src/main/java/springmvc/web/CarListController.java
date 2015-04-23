package springmvc.web;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import springmvc.service.CarManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CarListController implements Controller {

    public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {

        CarManager carManager = new CarManager();

        ModelAndView modelAndView = new ModelAndView("car_list");
        modelAndView.addObject("car_list", carManager.getCarList());

        return modelAndView;
    }
}

