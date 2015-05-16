package springmvc.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import springmvc.model.Order;
import springmvc.repositories.UserRepository;

import java.sql.SQLException;


public class OrderValidator implements Validator {

    @Autowired
    private UserRepository userRepository;

    public boolean supports(Class clazz) {
        return Order.class.equals(clazz);
    }

    public void validate(Object obj, Errors e) {
        Order order = (Order) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "price", "field.required", "Required field");

        if (!e.hasFieldErrors("price")) {
            if (Integer.parseInt(String.valueOf(order.getPrice())) <= 0) {
                e.rejectValue("price", "negativeValue", "Price can not be 0 or negative");
            }
            try {
                if(userRepository.getUser(order.getCustomerId()) == null) {
                    e.rejectValue("customerId", "wrong.format", "Customer was deleted/not exists");
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

        try {
            Integer.parseInt(String.valueOf(order.getPrice()));
        } catch (NumberFormatException e1) {
            e.rejectValue("price", "wrong.format", "Wrong price format");
        }
    }
}
