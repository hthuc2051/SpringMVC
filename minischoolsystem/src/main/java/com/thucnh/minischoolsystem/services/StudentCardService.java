package com.thucnh.minischoolsystem.services;


import com.thucnh.minischoolsystem.dtos.StudentCardDTO;

import java.util.List;

public interface StudentCardService {
    List<StudentCardDTO> getStudentCards();
    StudentCardDTO findByID(String id);
    void save(StudentCardDTO dto);
    void delete(String id);
}
