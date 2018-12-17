package com.thucnh.minischoolsystem.repositories;

import com.thucnh.minischoolsystem.models.StudentCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentCardRepository extends JpaRepository<StudentCard,Integer> {
}
