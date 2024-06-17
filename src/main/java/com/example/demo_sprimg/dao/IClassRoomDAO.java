package com.example.demo_sprimg.dao;
import com.example.demo_sprimg.entity.ClassRoom;

import java.util.List;

public interface IClassRoomDAO {
    void  saveClassRoom(ClassRoom classRoom);
    ClassRoom getClassRoomById(long id);
    List<ClassRoom> getAllClassRooms();
}