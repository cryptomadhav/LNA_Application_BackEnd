package com.LNAproject.LNAApplication.repository;

import com.LNAproject.LNAApplication.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends CrudRepository<User, String> {
}
