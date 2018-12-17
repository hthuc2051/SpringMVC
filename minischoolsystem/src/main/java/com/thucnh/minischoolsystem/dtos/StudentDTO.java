package com.thucnh.minischoolsystem.dtos;

import com.thucnh.minischoolsystem.models.Teacher;
import lombok.Data;

import java.util.List;
@Data
public class StudentDTO {

    private Integer id;
    private String name,address;
    private Integer age;

    private TeacherDTO teacher;

    private StudentCardDTO studentCard;

    private List<CourseDTO> courses;

    public StudentDTO() {
    }

    public StudentDTO(Integer id,String name, String address, Integer age, TeacherDTO teacher, StudentCardDTO studentCard, List<CourseDTO> courses) {
        this.id =id;
        this.name = name;
        this.address = address;
        this.age = age;
        this.teacher = teacher;
        this.studentCard = studentCard;
        this.courses = courses;
    }

    public StudentDTO(Integer id, String name, String address, Integer age, TeacherDTO teacher, StudentCardDTO studentCard) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;
        this.teacher = teacher;
        this.studentCard = studentCard;
    }


    public StudentDTO(String name, String address, Integer age, Teacher teacher, StudentCardDTO studentCardDTO, List<CourseDTO> courseDTOList) {
    }
}
