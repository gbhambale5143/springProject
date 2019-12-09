package com.cdac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@Autowired
	private UserDao userdao;

	@GetMapping("/singup")
	public ModelAndView signup() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("singup");

		return mv;

	}

	@PostMapping("/singup")

	public ModelAndView registerUserToDb(User user) {

		this.userdao.create(user);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("signin");
		return mv;

	}

	@GetMapping("/signin")
	public ModelAndView signinPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("signin");
		return mv;
	}

	@PostMapping("/signin")
	public ModelAndView ValidateUser(User user) {
		
		ModelAndView mv = new ModelAndView();
			boolean auth = this.userdao.validateUser(user);

			
				if (auth) {
				mv.setViewName("home");
			} else {
				mv.setViewName("signin");
			}
			return mv;

        


		// mv.setViewName("home");//redirecting user to home.jsp after successfulll
		// login
		
	}

}
