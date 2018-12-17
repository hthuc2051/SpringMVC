package com.thucnh.minischoolsystem.services.servicesImpl;

import com.thucnh.minischoolsystem.dtos.StudentCardDTO;
import com.thucnh.minischoolsystem.services.StudentCardService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentCardServiceImpl implements StudentCardService {
    @Override
    public List<StudentCardDTO> getStudentCards() {
        return null;
    }

    @Override
    public StudentCardDTO findByID(String id) {
        return null;
    }

    @Override
    public void save(StudentCardDTO dto) {

    }

    @Override
    public void delete(String id) {

    }
}
