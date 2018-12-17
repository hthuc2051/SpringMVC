package com.thucnh.minischoolsystem.controllers;


import com.thucnh.minischoolsystem.dtos.CourseDTO;
import com.thucnh.minischoolsystem.dtos.StudentDTO;
import com.thucnh.minischoolsystem.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(path = "/students")
    public List<StudentDTO> getAllStudents(){
        return  studentService.getAllStudents();
    }

    @GetMapping(path = "/students/{id}")
    public StudentDTO findByID(@PathVariable("id") Integer id){
        return  studentService.findByID(id);
    }

    @GetMapping(path = "/students/name/{name}")
    public List<StudentDTO> findByName(@PathVariable("name") String name){
        return  studentService.findByName(name);
    }

    @PutMapping(path = "/students")
    public StudentDTO update(@RequestBody StudentDTO dto){
          studentService.update(dto);
          return dto;
    }
    @PostMapping(path = "/students")
    public StudentDTO add(@RequestBody StudentDTO dto){
        studentService.add(dto);
        return dto;
    }
    @PutMapping(path = "/students/{id}")
    public void addCourses(@PathVariable("id") Integer id, @RequestBody List<CourseDTO> courseDTOList) {
        studentService.addCourses(id,courseDTOList);
    }
}
