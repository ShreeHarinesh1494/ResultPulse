package com.ResultPulse.ResultPulse.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student
{
    @Id
    private int rollno;
    private String name;
    private String email;
    private String phonenumber;
    private String password;

    @ManyToOne
    private Department department;
    private int yearofjoining;
}
