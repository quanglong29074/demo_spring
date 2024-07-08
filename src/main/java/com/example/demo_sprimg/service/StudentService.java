package com.example.demo_sprimg.service;
import com.example.demo_sprimg.entity.Student;
import com.example.demo_sprimg.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;


    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }


    public Optional<Student> getStudentById(int id) {
        return studentRepository.findById(id);
    }


    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }


    public void deleteStudentById(int id) {
        studentRepository.deleteById(id);
    }


    public boolean existsById(int id) {
        return studentRepository.existsById(id);
    }
}
