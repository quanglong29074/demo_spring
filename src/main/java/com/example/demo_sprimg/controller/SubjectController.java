package com.example.demo_sprimg.controller;

import com.example.demo_sprimg.entity.Subject;
import com.example.demo_sprimg.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping
    public ResponseEntity<List<Subject>> getAllSubjects() {
        List<Subject> subjects = subjectService.getAllSubjects();
        return ResponseEntity.ok(subjects);
    }

    @GetMapping("/{code}")
    public ResponseEntity<Subject> getSubjectByCode(@PathVariable String code) {
        Optional<Subject> subject = subjectService.getSubjectByCode(code);
        if (subject.isPresent()) {
            return ResponseEntity.ok(subject.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Subject> createSubject(@RequestBody Subject subject) {
        subjectService.saveSubject(subject);
        return ResponseEntity.ok(subject);
    }

    @PutMapping("/{code}")
    public ResponseEntity<Subject> updateSubject(@PathVariable String code, @RequestBody Subject subjectDetails) {
        Optional<Subject> subject = subjectService.getSubjectByCode(code);
        if (subject.isPresent()) {
            Subject updatedSubject = subject.get();
            updatedSubject.setName(subjectDetails.getName());
            updatedSubject.setCredit(subjectDetails.getCredit());
            subjectService.updateSubject(updatedSubject);
            return ResponseEntity.ok(updatedSubject);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteSubject(@PathVariable String code) {
        Optional<Subject> subject = subjectService.getSubjectByCode(code);
        if (subject.isPresent()) {
            subjectService.deleteSubject(code);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
