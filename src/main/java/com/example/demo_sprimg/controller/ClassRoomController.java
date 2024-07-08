package com.example.demo_sprimg.controller;

import com.example.demo_sprimg.entity.ClassRoom;
import com.example.demo_sprimg.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/classroom")
public class ClassRoomController {
    private final ClassRoomService classRoomService;
    @Autowired
    public ClassRoomController(ClassRoomService classRoomService) {
        this.classRoomService = classRoomService;
    }

    @GetMapping("/list")
    public String getClassRoomList(Model model) {
        List<ClassRoom> classRooms = classRoomService.getAllClassRooms();
        model.addAttribute("classRooms", classRooms);
        return "classroom/index";
    }

    @GetMapping("/add")
    public String addClassRoom(Model model) {
        model.addAttribute("classRoom", new ClassRoom());
        return "classroom/addClass"; // This should be the name of your add form view
    }
    @PostMapping("/add")
    public String addClassRoom(@ModelAttribute ClassRoom classRoom) {
        classRoomService.saveClassRoom(classRoom);
        return "redirect:/classroom/list";
    }

    @GetMapping("/edit/{id}")
    public String editClassRoom(@PathVariable Integer id, Model model) {
        Optional<ClassRoom> classRoom = classRoomService.getClassRoomById(id);
        if (classRoom.isPresent()) {
            model.addAttribute("classRoom", classRoom.get());
            return "classroom/editClass";
        } else {
            return "redirect:/classroom/list";
        }
    }

    @PostMapping("/edit/{id}")
    public String updateClassRoom(@PathVariable Integer id, @ModelAttribute ClassRoom classRoom) {
        classRoom.setIdClass(id);
        classRoomService.updateClassRoom(classRoom);
        return "redirect:/classroom/list";    }

    @GetMapping("/delete/{id}")
    public String deleteClassRoom(@PathVariable Integer id) {
        classRoomService.deleteClassRoom(id);
        return "redirect:/classroom/list";    }

//    @PostMapping("/save")
//    public String getClassRoomList() {
//        System.out.println("get class room list");
//        return "classroom/index.html";
//
//    }
}















//@Autowired
//    private ClassRoomRepository classRoomRepository;
//
//    @GetMapping
//    public List<ClassRoom> getAllClassRooms() {
//        return classRoomRepository.findAll();
//    }
//
//    @PostMapping
//    public ClassRoom createClassRoom(@RequestBody ClassRoom classRoom) {
//        return classRoomRepository.save(classRoom);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<ClassRoom> getClassRoomById(@PathVariable(value = "id") Integer id) {
//        Optional<ClassRoom> classRoom = classRoomRepository.findById(id);
//        if (classRoom.isPresent()) {
//            return ResponseEntity.ok().body(classRoom.get());
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<ClassRoom> updateClassRoom(@PathVariable(value = "id") Integer id, @RequestBody ClassRoom classRoomDetails) {
//        Optional<ClassRoom> classRoomOpt = classRoomRepository.findById(id);
//        if (classRoomOpt.isPresent()) {
//            ClassRoom classRoom = classRoomOpt.get();
//            classRoom.setClassName(classRoomDetails.getClassName());
//            classRoom.setNumberMember(classRoomDetails.getNumberMember());
//            final ClassRoom updatedClassRoom = classRoomRepository.save(classRoom);
//            return ResponseEntity.ok(updatedClassRoom);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteClassRoom(@PathVariable(value = "id") Integer id) {
//        Optional<ClassRoom> classRoom = classRoomRepository.findById(id);
//        if (classRoom.isPresent()) {
//            classRoomRepository.delete(classRoom.get());
//            return ResponseEntity.ok().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
