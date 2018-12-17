package com.thucnh.minischoolsystem.repositories;

import com.thucnh.minischoolsystem.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CourseRepository extends JpaRepository<Course,Integer> {

}
