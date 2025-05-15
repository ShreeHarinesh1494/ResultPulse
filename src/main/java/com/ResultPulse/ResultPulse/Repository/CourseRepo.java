package com.ResultPulse.ResultPulse.Repository;

import com.ResultPulse.ResultPulse.Model.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends CrudRepository<Course, String> {
}
