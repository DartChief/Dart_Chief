package validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import springmvc.model.User;

public class UserValidator implements Validator {

    public boolean supports(Class clazz) {
        return User.class.equals(clazz);
    }

    public void validate(Object obj, Errors e) {
        User user = (User) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "age", "field.required", "Required field");
        if (!e.hasFieldErrors("age")) {
            if (user.getAge() <= 0) {
                e.rejectValue("age", "negativeValue", "Age can not be 0 or negative");
            }
        }
        try {
            Integer.parseInt(String.valueOf(user.getAge()));
        } catch (NumberFormatException e1) {
            e.rejectValue("age", "notNumeric", "Age should be a number");
        }

    }
}
