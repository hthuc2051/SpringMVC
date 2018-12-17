package com.thucnh.minischoolsystem.services;

import com.thucnh.minischoolsystem.dtos.CourseDTO;

import java.util.List;

public interface CourseService {
    List<CourseDTO> getAllCourses();
    CourseDTO findByID(String id);
    void save(CourseDTO dto);
    void delete(String id);
}
