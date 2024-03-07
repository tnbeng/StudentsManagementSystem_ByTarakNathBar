package in.tarak.main.services;

import java.util.List;

import in.tarak.main.entity.Student;
import in.tarak.main.entity.Teacher;

public interface ServiceInterface {
	
  public boolean add(Student stu);
  public boolean delete(String id);
  public boolean update(Student stu);
  public List<Student> show(Teacher teacher);
  public Student FindStudentByEmail(String email) ;
  
}
