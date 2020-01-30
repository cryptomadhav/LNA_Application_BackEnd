package com.LNAproject.LNAApplication.repository;

import com.LNAproject.LNAApplication.domain.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface StudentRepository extends CrudRepository<Student, String> {
}
