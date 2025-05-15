package com.ResultPulse.ResultPulse.DTO.Course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO
{
    private String courseid;
    private String coursename;
    private int credits;
    private  int semid;
}
