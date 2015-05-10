package springmvc.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import springmvc.model.Order;


public class OrderValidator implements Validator {
    public boolean supports(Class clazz) {
        return Order.class.equals(clazz);
    }

    public void validate(Object obj, Errors e) {
        Order order = (Order) obj;
        try {
            if (Integer.parseInt(String.valueOf(order.getPrice())) <= 0) {
                e.rejectValue("price", "negativevalue", "Price can not be negative");
            }
        } catch (NumberFormatException e1) {
            e.rejectValue("price", "wrong.format", "Wrong age format");
        }
    }
}
