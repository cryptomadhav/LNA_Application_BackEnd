package com.LNAproject.LNAApplication.repository;

import com.LNAproject.LNAApplication.domain.Request;
import org.springframework.data.repository.CrudRepository;

public interface RequestRepository extends CrudRepository<Request, String> {
}
