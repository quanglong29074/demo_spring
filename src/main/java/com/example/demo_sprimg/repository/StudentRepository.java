package com.example.demo_sprimg.repository;

import com.example.demo_sprimg.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query(value = "CALL GetStudent()", nativeQuery = true)
    List<Student> getStudentsFromProcedure();
}
