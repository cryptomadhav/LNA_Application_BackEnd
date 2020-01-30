package com.LNAproject.LNAApplication.repository;

import com.LNAproject.LNAApplication.domain.TripData;
import org.springframework.data.repository.CrudRepository;

public interface TripDataRepository extends CrudRepository<TripData, String> {
}
