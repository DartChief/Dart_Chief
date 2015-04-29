package springmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import springmvc.model.Car;
import springmvc.service.BrandManager;

import javax.validation.Valid;

@Controller

@RequestMapping("/new_car.html")

public class CarNewController {

    @ModelAttribute("car")
    public Car getCarObject() {

        return new Car();

    }

    @RequestMapping(method = RequestMethod.GET)
    public String initializeForm(ModelMap model) {

        BrandManager brandManager = new BrandManager();

        model.addAttribute("brandList", brandManager.getBrandList());

        System.out.println("CAR GET");

        return "new_car";

    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(
            @RequestParam("brand") Long brand,
            @ModelAttribute("car") @Valid Car car,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "new_car";
        }

        System.out.println("Adding: " + car.getModel() + ", " + car.getPrice() + ", brand: " + brand);
        return "redirect:hello_world.html";
    }

    /*

    @Override

    protected Object formBackingObject(HttpServletRequest request) throws Exception {

        Car defaultCar = new Car();

        defaultCar.setModel("new model");

        defaultCar.setPrice(new BigDecimal(15000));

        return defaultCar;

    }

    @Override

    protected Map referenceData(HttpServletRequest request) throws Exception {

        Map<Object, Object> dataMap = new HashMap<Object, Object>();

        BrandManager brandManager = new BrandManager();

        dataMap.put("brandList", brandManager.getBrandList());

        return dataMap;

    }

    @Override

    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) 

throws Exception {

        binder.setDisallowedFields(new String[] {"brand"});

        Car car = (Car)binder.getTarget();

        // set car's brand from request parameter brand id

        BrandManager brandManager = new BrandManager();

        Long brandId = null;

        try {

            brandId = Long.parseLong(request.getParameter("brand"));

        } catch (Exception e) {}

        if (brandId != null) {

            Brand brand = brandManager.getBrandById(brandId);

            car.setBrand(brand);

        }

    }

    @Override

    public ModelAndView onSubmit(Object command) throws ServletException {

        CarManager carManager = new CarManager();

        carManager.createCar((Car)command);

        return new ModelAndView(new RedirectView(getSuccessView()));

    }*/

}