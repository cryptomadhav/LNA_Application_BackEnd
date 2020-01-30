package com.LNAproject.LNAApplication.repository;

import com.LNAproject.LNAApplication.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
