package com.example.demo_sprimg.controller;

import com.example.demo_sprimg.entity.ClassRoom;
import com.example.demo_sprimg.entity.Student;
import com.example.demo_sprimg.repository.StudentRepository;
import com.example.demo_sprimg.service.ClassRoomService;
import com.example.demo_sprimg.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/students")
public class StudentController {
    private final ClassRoomService classRoomService;

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService,ClassRoomService classRoomService) {
        this.studentService = studentService;
        this.classRoomService = classRoomService;
    }

    @GetMapping("/list")
    public String listStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "student/index";
    }

    @GetMapping("/add")
    public String showAddStudentForm(Model model) {
        List<ClassRoom> classRooms = classRoomService.getAllClassRooms();
        model.addAttribute("student", new Student());
        model.addAttribute("classRooms", classRooms);
        return "student/addStudent";
    }

    @PostMapping("/add")
    public String createStudent(@ModelAttribute Student student) {
        studentService.saveStudent(student);
        return "redirect:/students/list";
    }



     @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable Integer id, Model model) {
        Optional<Student> student = studentService.getStudentById(id);
        if (student.isPresent()) {
            List<ClassRoom> classRooms = classRoomService.getAllClassRooms();
            model.addAttribute("student", student.get());
            model.addAttribute("classRooms", classRooms);
            return "student/editStudent";
        } else {
            return "redirect:/students/list";
        }
    }

    @PostMapping("/edit/{id}")
    public String updateStudent(@PathVariable int id, @ModelAttribute Student student) {
        if (studentService.existsById(id)) {
            student.setId(id);
            studentService.saveStudent(student);
        }
        return "redirect:/students/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        if (studentService.existsById(id)) {
            studentService.deleteStudentById(id);
        }
        return "redirect:/students/list";
    }
}
