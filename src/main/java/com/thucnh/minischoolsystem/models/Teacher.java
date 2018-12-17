package com.thucnh.minischoolsystem.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer age;
    @OneToMany(mappedBy = "teacher",fetch = FetchType.EAGER)
    private List<Student> studentList;


    public Teacher() {
    }

    public Teacher(Integer id) {
        this.id = id;
    }

    public Teacher(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Teacher(String name, Integer age, List<Student> studentList) {
        this.name = name;
        this.age = age;
        this.studentList = studentList;
    }
}
