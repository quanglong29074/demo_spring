package com.example.demo_sprimg.service;


import  com.example.demo_sprimg.entity.ClassRoom;
import  com.example.demo_sprimg.repository.ClassRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassRoomService {
    @Autowired
    private ClassRoomRepository classRoomRepository;

    public List<ClassRoom> getAllClassRooms() {
        return classRoomRepository.findAll();
    }

    public Optional<ClassRoom> getClassRoomById(int id) {
        return classRoomRepository.findById(id);
    }

    public void saveClassRoom(ClassRoom classRoom) {
        classRoomRepository.save(classRoom);
    }
    public void updateClassRoom(ClassRoom classRoom) {
        classRoomRepository.save(classRoom);
    }
    public void deleteClassRoom(int id) {
        classRoomRepository.deleteById(id);
    }
}