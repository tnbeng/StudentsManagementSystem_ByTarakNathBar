package in.tarak.main.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class Student {
	
	@NotBlank(message = "Name is required")
  private String name;
	@NotBlank(message = "Name is required")
  private String rollno;
	@NotBlank(message = "Phoneno is required")
  private String phoneno;
	@NotBlank(message = "Email is required")
  @Id
  private String email;
	@NotBlank(message = "Technology is required")
  private String lang;
	@ManyToOne
	@JoinColumn(name="teacher_email")
  private Teacher teacher;
  private String image_name;
  
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getRollno() {
	return rollno;
}
public void setRollno(String rollno) {
	this.rollno = rollno;
}
public String getPhoneno() {
	return phoneno;
}
public void setPhoneno(String phoneno) {
	this.phoneno = phoneno;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getLang() {
	return lang;
}
public void setLang(String lang) {
	this.lang = lang;
}
public String getImage_name() {
	return image_name;
}
public void setImage_name(String image_name) {
	this.image_name = image_name;
}
public Teacher getTeacher() {
	return teacher;
}
public void setTeacher(Teacher teacher) {
	this.teacher = teacher;
}


}
