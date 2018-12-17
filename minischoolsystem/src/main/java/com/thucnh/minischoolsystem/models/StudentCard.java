package com.thucnh.minischoolsystem.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "studentcard")
public class StudentCard {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "num")
    private String num;

    @OneToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    public StudentCard() {
    }
    public StudentCard(String num) {
        this.num = num;
    }


    public StudentCard(String num, Student student) {
        this.num = num;
        this.student = student;
    }

    public StudentCard(Integer id, String num) {
        this.id=id;
        this.num=num;
    }
}
