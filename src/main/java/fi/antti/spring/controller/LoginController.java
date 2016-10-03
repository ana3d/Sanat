package fi.antti.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class LoginController {

	final static Logger logger = LoggerFactory.getLogger(Controller.class);
	
	@RequestMapping(method = RequestMethod.GET)
	public String etusivu(ModelMap model) {
		
		return "index";
	}
	

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {

		return "login";

	}

	@RequestMapping(value = "/loginfail", method = RequestMethod.GET)
	public String loginerror(Model model) {

		model.addAttribute("loginerror", "true");
		return "login";

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model) {

		model.addAttribute("loggedout", "true");
		return "login";

	}

}
