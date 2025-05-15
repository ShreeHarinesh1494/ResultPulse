package com.ResultPulse.ResultPulse.DTO.Student;

import com.ResultPulse.ResultPulse.Model.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO
{
    private int rollno;
    private String name;
    private String email;
    private String phonenumber;
    private String password;
    private int deptid;
    private int yearofjoining;
}
