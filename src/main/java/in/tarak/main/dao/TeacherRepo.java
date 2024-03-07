package in.tarak.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.tarak.main.entity.Teacher;

public interface TeacherRepo extends JpaRepository<Teacher, String> {
       Teacher getByEmail(String email);
}
