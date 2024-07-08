package com.example.demo_sprimg.service;

import com.example.demo_sprimg.entity.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
    List<Student> getAllStudents();
    Optional<Student> getStudentById(int id);
    Student saveStudent(Student student);
    void deleteStudentById(int id);
    boolean existsById(int id);
}
