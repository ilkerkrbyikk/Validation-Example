package com.Ilker.ValidationExample.repository;

import com.Ilker.ValidationExample.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
