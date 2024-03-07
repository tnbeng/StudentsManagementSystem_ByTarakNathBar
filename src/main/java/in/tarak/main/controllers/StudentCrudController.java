package in.tarak.main.controllers;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.tarak.main.entity.Student;
import in.tarak.main.entity.Teacher;
import in.tarak.main.services.ServiceImp;
import jakarta.servlet.http.HttpSession;

@Controller
public class StudentCrudController {
	
	@Autowired
	ServiceImp obj;
		
	@PostMapping("/addStudentForm")
	public String addStudent(@Validated @ModelAttribute("Student") Student stu, 
			                 BindingResult result,
			                 @RequestParam("file") MultipartFile file,
			                 Model model,HttpSession session)
	{
		if(result.hasErrors())
		{
			return "addstudent";
		}
		
		try
		{
			String file_name=file.getOriginalFilename();
			stu.setImage_name(file_name);
			Teacher teacher=(Teacher) session.getAttribute("teacher");
			if(teacher==null)
			{
				return "login";
			}
			stu.setTeacher(teacher);
			boolean status=obj.add(stu);
			  if(status)
			  {
				  
				  if(!file_name.isEmpty())
				    { 
					 
				      String image_upload_folder= "src/main/resources/static/upload";
					  Path target_path=Paths.get(image_upload_folder,file_name);
					  Files.copy(file.getInputStream(), target_path, StandardCopyOption.REPLACE_EXISTING);
				    }	  
			   model.addAttribute("success","success");
			  }
			  else
			  {
			   model.addAttribute("failed","error");
			  }
			
			  
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		   
	 return "addstudent";
	}
	
	
	
	
	@GetMapping("/showStudent")
	public String studentList(@RequestParam(defaultValue = "1") int page,Model model,HttpSession session)
	{   
		int perpage_size=5;
		
		Teacher teacher=(Teacher) session.getAttribute("teacher");
		if(teacher==null)
		{
			return "login";
		}
		List<Student> stu=obj.show(teacher);
		int total_size=stu.size();
		int required_pages=(int)Math.ceil((double) total_size/perpage_size);
		
		int index_size=(page-1)*perpage_size;
		int end_size=Math.min(index_size+perpage_size, total_size);
		List<Student> subStu=stu.subList(index_size, end_size);
		
		model.addAttribute("model_student_list",subStu);
		model.addAttribute("required_pages",required_pages);
		model.addAttribute("current_page",page);
		
		return "studentlist";
	}
	
	
	
	@GetMapping("/deleteStudent")
	public String deleteStudent(@RequestParam("email") String id,@RequestParam("page")int page,HttpSession session,RedirectAttributes redatt)
	{   
		System.out.println("Page Number:"+page);
	    Teacher teacher=(Teacher) session.getAttribute("teacher");
	    if(teacher==null)
		{
			return "login";
		}
		
		try
		{
			Student stu=obj.FindStudentByEmail(id);
			String img_name=stu.getImage_name();
		    obj.delete(id);
		  
		    if(img_name!=null)
		    {
		    	String upload_folder_name="src/main/resources/static/upload";
		    	Path target_path=Paths.get(upload_folder_name,img_name);
		    	if(Files.exists(target_path))
		    	{
		    		Files.delete(target_path);
		    	}
		    }
		    redatt.addAttribute("page",page);
		    return "redirect:/showStudent";
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			redatt.addAttribute("current_page",page);
			return "redirect:/showStudent";
		}
	}
	
	
	
	@GetMapping("/updateStudent")
	public String updateStudent(@RequestParam("email") String email,Model model,HttpSession session)
	{   
		Teacher teacher=(Teacher) session.getAttribute("teacher");
	    if(teacher==null)
		{
			return "login";
		}
		Student stu=obj.FindStudentByEmail(email);
		if(stu==null)
		{  
			model.addAttribute("message","success");
			return "student-update";
		}
		
		else
		{   
			model.addAttribute("message","failed");
			model.addAttribute("stu", stu);
			model.addAttribute("Student",new Student());
			
			return "student-update";
		}
	}
	
	
	
	
	@PostMapping("/updateStudentForm")
	public String updateStudent(@Validated @ModelAttribute("Student") Student stu, 
			                 BindingResult result,
			                 @RequestParam("file") MultipartFile file,
			                 Model model,HttpSession session)
	{
		if(result.hasErrors())
		{
			return "student-update";
		}
		
		try
		{
			Student existing_student=obj.FindStudentByEmail(stu.getEmail());
			String existing_imag_name=existing_student.getImage_name();
			 if(!existing_imag_name.isBlank())
			    {
				    System.out.println("old file exist:"+existing_imag_name);
			    	String upload_folder_name="src/main/resources/static/upload";
			    	Path target_path=Paths.get(upload_folder_name,existing_imag_name);
			    	
			    	if(Files.exists(target_path))
			    	{
			    		Files.delete(target_path);
			    	}
			    			
			    }
			
			 stu.setImage_name(file.getOriginalFilename());
			 Teacher teacher=(Teacher) session.getAttribute("teacher");
			 stu.setTeacher(teacher);
			 boolean status=obj.add(stu);
			  String file_name=file.getOriginalFilename();
			  if(status)
			  {
				 
				  if(!file_name.isEmpty())
				    { 
					  System.out.println("New File Name:"+file_name);
				      String image_upload_folder= "src/main/resources/static/upload";
					  Path target_path=Paths.get(image_upload_folder,file_name);
					
					 
					  Files.copy(file.getInputStream(), target_path, StandardCopyOption.REPLACE_EXISTING);
					 
				    }	  
			   model.addAttribute("success","success");
			  }
			  else
			  {
			   model.addAttribute("failed","error");
			  }
			
			  
		}
		catch(Exception e)
		{
			e.printStackTrace();
			model.addAttribute("error","Exceptiion occured");
		}
		   
		 return "student-update";
	}


}
