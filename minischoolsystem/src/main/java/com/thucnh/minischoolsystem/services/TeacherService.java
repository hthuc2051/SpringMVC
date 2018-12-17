package com.thucnh.minischoolsystem.services;


import com.thucnh.minischoolsystem.dtos.TeacherDTO;

import java.util.List;

public interface TeacherService {
    List<TeacherDTO> getAllTeachers();
    TeacherDTO findByID(String id);
    void save(TeacherDTO dto);
    void delete(String id);
}
