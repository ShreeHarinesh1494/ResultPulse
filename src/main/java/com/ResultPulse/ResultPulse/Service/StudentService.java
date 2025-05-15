package com.ResultPulse.ResultPulse.Service;

import com.ResultPulse.ResultPulse.DTO.Student.StudentDTO;
import com.ResultPulse.ResultPulse.DTO.Student.StudentLoginDTO;
import com.ResultPulse.ResultPulse.Model.Department;
import com.ResultPulse.ResultPulse.Model.Student;
import com.ResultPulse.ResultPulse.Repository.DepartmentRepo;
import com.ResultPulse.ResultPulse.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService
{
    @Autowired
    private StudentRepo sr;

    @Autowired
    private DepartmentRepo dr;

    public String addstudent(StudentDTO studentDTO) {
        Optional<Department> deptOptional = dr.findById(studentDTO.getDeptid());
        if (!deptOptional.isPresent()) {
            return "Department with ID " + studentDTO.getDeptid() + " not found.";
        }

        Student student = new Student();
        student.setRollno(studentDTO.getRollno());
        student.setName(studentDTO.getName());
        student.setEmail(studentDTO.getEmail());
        student.setPhonenumber(studentDTO.getPhonenumber());
        student.setPassword(studentDTO.getPassword());
        student.setDepartment(deptOptional.get());
        student.setYearofjoining(studentDTO.getYearofjoining());

        sr.save(student);
        return "Student added successfully with Roll No: " + student.getRollno();
    }

    public Student getstudentbyid(int rollno) {
        return sr.findById(rollno)
                .orElseThrow(() -> new RuntimeException("Student not found with Roll No: " + rollno));
    }

    public String loginStudent(StudentLoginDTO dto) {
        Student student = sr.findById(dto.getRollno()).orElse(null);

        if (student == null) {
            return "Roll number not found";
        }

        if (student.getPassword().equals(dto.getPassword())) {
            return "Login successful";
        } else {
            return "Invalid password";
        }
    }
}
