package com.LNAproject.LNAApplication.repository;

import com.LNAproject.LNAApplication.domain.Request;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface RequestRepository extends CrudRepository<Request, String> {
}
