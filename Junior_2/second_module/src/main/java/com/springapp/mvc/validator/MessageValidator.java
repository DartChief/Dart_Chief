package com.springapp.mvc.validator;

import com.springapp.mvc.entity.Message;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

/**
 * Created by dednakov on 03.02.2016.
 */
public class MessageValidator {

    public boolean supports(Class clazz) {
        return Message.class.equals(clazz);
    }

    public void validate(Object obj, Errors e) {

//        Message message = (Message) obj;

        ValidationUtils.rejectIfEmptyOrWhitespace(e, "author", "authorNotEmpty", "Required field");

        ValidationUtils.rejectIfEmptyOrWhitespace(e, "text", "field.required", "Required field");
    }
}
