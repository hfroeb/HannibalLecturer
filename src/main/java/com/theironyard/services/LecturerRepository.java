package com.theironyard.services;

import com.theironyard.entities.Lecturer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by halleyfroeb on 10/18/16.
 */
public interface LecturerRepository extends CrudRepository<Lecturer, Integer> {
}
