package com.example.Studentmanagement.service;

import com.example.Studentmanagement.entity.Student;
import com.example.Studentmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    // GET ALL
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    // ADD
    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    // UPDATE
    public Student updateStudent(Long id, Student student) {
        Student existing = repository.findById(id).orElse(null);

        if (existing != null) {
            existing.setName(student.getName());
            existing.setEmail(student.getEmail());
            existing.setCourse(student.getCourse());
            return repository.save(existing);
        }
        return null;
    }

    // DELETE
    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }
}