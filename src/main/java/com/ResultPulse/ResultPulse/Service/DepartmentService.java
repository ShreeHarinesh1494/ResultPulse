package com.ResultPulse.ResultPulse.Service;


import com.ResultPulse.ResultPulse.Model.Department;
import com.ResultPulse.ResultPulse.Repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService
{
    @Autowired
    private DepartmentRepo dr;

    public String postdept(Department dept) {
        if (dept.getDeptname() == null || dept.getDeptname().trim().isEmpty()) {
            return "Department name cannot be empty.";
        }

        // Check if department with same name already exists
        if (dr.existsByDeptnameIgnoreCase(dept.getDeptname().trim())) {
            return "Department '" + dept.getDeptname().trim() + "' already exists.";
        }

        Department savedDept = dr.save(dept);
        return "Department added with ID: " + savedDept.getDeptid();
    }


    public String postAllDepts(List<Department> departments) {
        List<Department> newDepartments = new ArrayList<>();

        for (Department dept : departments) {
            if (!dr.existsByDeptnameIgnoreCase(dept.getDeptname()))
            {
                newDepartments.add(dept);
            }
        }

        if (newDepartments.isEmpty()) {
            return "No new departments added. All already exist.";
        }

        dr.saveAll(newDepartments);
        return newDepartments.size() + " new department(s) added successfully.";
    }

    public List<Department> getall()
    {
        List<Department> departments = (List<Department>) dr.findAll();
        if (departments.isEmpty())
        {
            throw new RuntimeException("No departments found.");
        }
        return departments;
    }

    public Department getbyid(int deptid)
    {
        Optional<Department> optionalDept = dr.findById(deptid);
        return optionalDept.orElseThrow(() ->
                new RuntimeException("Department not found with ID: " + deptid));
    }
}
