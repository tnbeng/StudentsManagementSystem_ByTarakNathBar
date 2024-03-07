package in.tarak.main.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.mysql.cj.Session;

import in.tarak.main.dao.TeacherRepo;
import in.tarak.main.entity.Teacher;
import jakarta.servlet.http.HttpSession;

@Controller
public class TeacherController {
	@Autowired
	TeacherRepo db;
	
	@GetMapping("/teacher_register")
	public String openRegisterForTeacher(Model model)
	{   
		model.addAttribute("Teacher", new Teacher());
		return "teacher-register";
	}
	@PostMapping("/addTeacher")
	public String addTeacher(@Validated @ModelAttribute("Teacher") Teacher ref, BindingResult result,Model model)
	{
		if(result.hasErrors())
		{
			return "teacher-register";
		}
		try {
			db.save(ref);
			model.addAttribute("success","success");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			model.addAttribute("error", "failed");
		}
		return "teacher-register";
	}
	
	@PostMapping("/loginForm")
	public String loginForm(String email,String password,Model model,HttpSession session)
	{
		Teacher ref=db.getByEmail(email);
		if(ref!=null && password.equals(ref.getPassword()))
		{  
			session.setAttribute("teacher", ref);
			return "admin";
		}
		else
		{  

		    model.addAttribute("error","failed");
			return "login";
			
		}
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "login";
	}
	@RequestMapping("/admin")
	public String openAdmin()
	{
		return "admin";
	}

}
