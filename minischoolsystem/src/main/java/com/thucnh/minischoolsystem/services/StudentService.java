package com.thucnh.minischoolsystem.services;


import com.thucnh.minischoolsystem.dtos.CourseDTO;
import com.thucnh.minischoolsystem.dtos.StudentDTO;

import java.util.List;

public interface StudentService {
    List<StudentDTO> getAllStudents();
    StudentDTO findByID(Integer id);
    void add(StudentDTO dto);
    void update(StudentDTO dto);
    void delete(String id);
    void addCourses(Integer id,List<CourseDTO> courseDTOList);
    List<StudentDTO> findByName(String name);
}
