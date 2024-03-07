package in.tarak.main.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.tarak.main.entity.Student;

public interface StudentRepo extends JpaRepository<Student, String> {
       Student findByEmail(String Email);
       List<Student> findByTeacherEmail(String teacherEmail);
}
