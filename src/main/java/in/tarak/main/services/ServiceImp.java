package in.tarak.main.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.tarak.main.dao.StudentRepo;
import in.tarak.main.dao.TeacherRepo;
import in.tarak.main.entity.Student;
import in.tarak.main.entity.Teacher;

@Service
public class ServiceImp implements ServiceInterface{
    @Autowired
	StudentRepo db;
	@Autowired
	TeacherRepo repo;
	@Override
	public boolean add(Student stu) {
		
		try
		{
			db.save(stu);
		    return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(String id) {

		try
		{
			db.deleteById(id);
		    return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Student stu) {
		

		try
		{
			db.save(stu);
		    return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Student> show(Teacher teacher) {
	     String teacher_email=teacher.getEmail();
	     return db.findByTeacherEmail(teacher_email);
			
	}

	@Override
	public Student FindStudentByEmail(String email) {
		Student stu=db.findByEmail(email);
		return stu;
	}
	


}
