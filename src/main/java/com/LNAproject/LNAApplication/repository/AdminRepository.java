package com.LNAproject.LNAApplication.repository;

import org.springframework.data.repository.CrudRepository;
import com.LNAproject.LNAApplication.domain.Admin;

public interface AdminRepository extends CrudRepository<Admin, Long> {
}
