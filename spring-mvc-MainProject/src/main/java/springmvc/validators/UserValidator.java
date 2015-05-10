package springmvc.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import springmvc.model.User;

public class UserValidator implements Validator {
    public boolean supports(Class clazz) {
        return User.class.equals(clazz);
    }

    public void validate(Object obj, Errors e) {
        User user = (User) obj;
        try {
            if (user.getAge() <= 0) {
                e.rejectValue("age", "negativevalue", "Age can not be negative");
            }
        } catch (NumberFormatException e1) {
            e.rejectValue("age", "wrong.format", "Wrong price format");
        }
    }
}
