package com.example.Studentmanagement.repository;

import com.example.Studentmanagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}