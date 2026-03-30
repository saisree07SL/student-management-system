package com.example.Studentmanagement.controller;

import com.example.Studentmanagement.entity.Student;
import com.example.Studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    // GET ALL
    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    // ADD
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return service.saveStudent(student);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return service.updateStudent(id, student);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
        return "Student deleted successfully";
    }
}