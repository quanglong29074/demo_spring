package com.example.demo_sprimg.service;

import com.example.demo_sprimg.entity.Subject;
import com.example.demo_sprimg.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public Optional<Subject> getSubjectByCode(String code) {
        return subjectRepository.findById(code);
    }

    public void saveSubject(Subject subject) {
        subjectRepository.save(subject);
    }

    public void updateSubject(Subject subject) {
        subjectRepository.save(subject);
    }

    public void deleteSubject(String code) {
        subjectRepository.deleteById(code);
    }
}
