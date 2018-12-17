package com.thucnh.minischoolsystem.dtos;



import lombok.Data;



import java.util.List;

@Data
public class CourseDTO {
    private Integer id;
    private String name;
    private List<StudentDTO> students;

    public CourseDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public CourseDTO(Integer id, String name, List<StudentDTO> students) {
        this.id = id;
        this.name = name;
        this.students = students;
    }

}
