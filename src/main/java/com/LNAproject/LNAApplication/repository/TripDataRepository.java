package com.LNAproject.LNAApplication.repository;

import com.LNAproject.LNAApplication.domain.TripData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

public interface TripDataRepository extends CrudRepository<TripData, String> {
}
