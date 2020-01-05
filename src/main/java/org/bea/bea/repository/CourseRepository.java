package org.bea.bea.repository;

import org.bea.bea.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
//@Repository
@CrossOrigin(origins = "http://localhost:4200")

public interface CourseRepository extends JpaRepository<Course, Long> {
}
