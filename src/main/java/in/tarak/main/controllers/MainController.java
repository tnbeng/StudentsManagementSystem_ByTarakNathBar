package in.tarak.main.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import in.tarak.main.entity.Student;

@Controller
public class MainController {
   
	@GetMapping("/")
	public String openIndex()
	{
		return "index";
	}

	@GetMapping("/login")
	public String openLogin()
	{
		return "login";
	}
	@GetMapping("/register")
	public String openRegister(Model model)
	{
		model.addAttribute("Student",new Student());
		return "addstudent";
	}
	@GetMapping("/studentlist")
	public String openStudentList()
	{
		return "studentlist";
	}
	
	
}
