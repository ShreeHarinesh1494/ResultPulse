package com.ResultPulse.ResultPulse.Repository;


import com.ResultPulse.ResultPulse.Model.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends CrudRepository<Department, Integer> {
    boolean existsByDeptnameIgnoreCase(String deptname);
}
