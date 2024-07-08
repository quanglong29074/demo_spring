package com.example.demo_sprimg.repository;

import com.example.demo_sprimg.entity.ClassRoom;
import com.example.demo_sprimg.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, String> {
}
