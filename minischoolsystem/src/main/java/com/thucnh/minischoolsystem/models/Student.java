package com.thucnh.minischoolsystem.models;


import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name, address;
    private Integer age;
    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

    @OneToOne(mappedBy = "student")
    private StudentCard studentCard;

    @ManyToMany(targetEntity = Course.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "student_course", joinColumns = {
            @JoinColumn(name = "student_id", referencedColumnName = "id", updatable = true)}, inverseJoinColumns = {
            @JoinColumn(name = "course_id", referencedColumnName = "id", nullable = true, updatable = false)})
    private List<Course> courses;

    public Student() {
    }


    public Student(Integer id, String name, String address, Integer age, Teacher teacher, StudentCard studentCard, List<Course> courses) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;
        this.teacher = teacher;
        this.studentCard = studentCard;
        this.courses = courses;
    }

    public Student(Integer id, String name, String address, Integer age, Teacher teacher) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;
        this.teacher = teacher;
    }


}
