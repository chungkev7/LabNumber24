package co.grandcircus.LabNumber24.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.LabNumber24.dao.UserDao;
import co.grandcircus.LabNumber24.model.User;

@Controller
public class HomeController {

	@Autowired
	UserDao dao;
	
//	@RequestMapping("/")
//	public String homePage() {
//		return "index";
//	}
	
	@RequestMapping("/")
	public ModelAndView homePage() {
		return new ModelAndView("index", "productsList", dao.findAllProducts());
	}
	
	@RequestMapping("register")
	public String registerPage() {
		return "register";
	}
	
	@RequestMapping("add-user")
	public ModelAndView addUser(User user) {
		dao.addUser(user.getName());
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping("search-name")
	public ModelAndView searchCategory(@RequestParam("name") String name) {
		return new ModelAndView("index", "productsList", dao.searchByName(name));
	}
}
