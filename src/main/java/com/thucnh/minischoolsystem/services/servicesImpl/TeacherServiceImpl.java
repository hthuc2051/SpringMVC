package com.thucnh.minischoolsystem.services.servicesImpl;

import com.thucnh.minischoolsystem.dtos.TeacherDTO;
import com.thucnh.minischoolsystem.models.Teacher;
import com.thucnh.minischoolsystem.repositories.TeacherRepository;
import com.thucnh.minischoolsystem.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<TeacherDTO> getAllTeachers() {
        List<Teacher> teacherList =  teacherRepository.findAll();
        List<TeacherDTO> result = new ArrayList<>();
        for (Teacher teacher:teacherList
             ) {
            result.add(new TeacherDTO(teacher.getId(),teacher.getName(),teacher.getAge()));
        }
        return result;
    }

    @Override
    public TeacherDTO findByID(String id) {
        return null;
    }

    @Override
    public void save(TeacherDTO dto) {

    }

    @Override
    public void delete(String id) {

    }
}
