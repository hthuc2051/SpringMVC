package com.thucnh.minischoolsystem.controllers;

import com.thucnh.minischoolsystem.dtos.CourseDTO;
import com.thucnh.minischoolsystem.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;


    @RequestMapping(path = "/courses")
    public List<CourseDTO> getAllCourses(){
        return courseService.getAllCourses();
    }
}
