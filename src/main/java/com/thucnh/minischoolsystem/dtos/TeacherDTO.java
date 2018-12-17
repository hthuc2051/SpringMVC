package com.thucnh.minischoolsystem.dtos;


import lombok.Data;


import java.util.List;
@Data
public class TeacherDTO {

    private Integer id;
    private String name;
    private Integer age;
    private List<StudentDTO> studentList;


    public TeacherDTO() {
    }
    public TeacherDTO(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public TeacherDTO(String name, Integer age, List<StudentDTO> studentList) {
        this.name = name;
        this.age = age;
        this.studentList = studentList;
    }
}
