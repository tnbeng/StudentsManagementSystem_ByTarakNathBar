package in.tarak.main.entity;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Teacher {
  @NotBlank(message = "Name can't be blank")
  private String name;
  @NotBlank(message = "Email can't be blank ")
  @Id
  private String email;
  @NotBlank(message = "Password can't be blank")
  private String password;
  
  @OneToMany(mappedBy = "teacher",fetch = FetchType.EAGER)
  private List<Student> students;

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public List<Student> getStudents() {
	return students;
}
public void setStudents(List<Student> students) {
	this.students = students;
}

}
