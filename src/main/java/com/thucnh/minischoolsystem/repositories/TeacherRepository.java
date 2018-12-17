package com.thucnh.minischoolsystem.repositories;

import com.thucnh.minischoolsystem.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
}
