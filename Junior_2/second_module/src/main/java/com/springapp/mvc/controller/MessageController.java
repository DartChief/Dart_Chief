package com.springapp.mvc.controller;

import com.springapp.mvc.entity.Message;
import com.springapp.mvc.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.springapp.mvc.validator.MessageValidator;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

@Controller
@RequestMapping(value = "/messages")
public class MessageController {

	@Autowired
	public ReloadableResourceBundleMessageSource messageSource;

	@Autowired
	private MessageRepository messageRepository;

	@Autowired
	private MessageValidator messageValidator;

	@RequestMapping(value="/addMessage", method=RequestMethod.GET)
	public ModelAndView createMessage(ModelAndView modelAndView, @ModelAttribute("message") Message message) throws SQLException {
		modelAndView.addObject("message", message);
		modelAndView.setViewName("messageForm");
		return modelAndView;
	}

	@RequestMapping(value = "/listOfMessages", method=RequestMethod.GET)
	public ModelAndView listMessages(ModelAndView modelAndView, HttpServletRequest request, HttpServletResponse response) throws SQLException {
		modelAndView.addObject("messages", messageRepository.showMessages());
		modelAndView.addObject("success", request.getSession().getAttribute("answer"));

		request.getSession().removeAttribute("answer");

		modelAndView.setViewName("listMessages");
		return modelAndView;

	}


	@RequestMapping(value="/saveMessage", method=RequestMethod.POST)
	public ModelAndView saveMessage(@ModelAttribute("message") @Valid Message message, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws Exception {

		messageValidator.validate(message, result);

		if(result.hasErrors()) {
			return new ModelAndView("messageForm");
		}
		messageRepository.addMessage(message);

//		request.getSession().setAttribute("answer", "dsfsdds");
		request.getSession().setAttribute("answer", messageSource.getMessage("label.successMessage", null, Locale.ENGLISH));


		return new ModelAndView("redirect:listOfMessages");
	}
}