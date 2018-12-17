package com.thucnh.minischoolsystem.models;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @ManyToMany(targetEntity = Student.class, mappedBy = "courses", fetch = FetchType.EAGER)
    private List<Student> students;

    public Course() {
    }

    public Course(String name) {
        this.name = name;
    }
    public Course(Integer id) {
        this.id = id;
    }
    public Course(Integer id,String name) {
        this.id = id;
        this.name = name;
    }
}
