package com.thucnh.minischoolsystem.repositories;

import com.thucnh.minischoolsystem.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    List<Student> findStudentsByNameContains(String name);

}
