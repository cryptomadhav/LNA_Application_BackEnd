package com.LNAproject.LNAApplication.repository;

import com.LNAproject.LNAApplication.domain.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {
}
