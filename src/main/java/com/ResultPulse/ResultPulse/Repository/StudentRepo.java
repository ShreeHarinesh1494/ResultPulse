package com.ResultPulse.ResultPulse.Repository;

import com.ResultPulse.ResultPulse.Model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends CrudRepository<Student, Integer> {
}
