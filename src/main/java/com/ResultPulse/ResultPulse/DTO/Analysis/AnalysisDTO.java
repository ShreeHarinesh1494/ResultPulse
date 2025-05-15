package com.ResultPulse.ResultPulse.DTO.Analysis;

import com.ResultPulse.ResultPulse.DTO.CourseAnalysisDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnalysisDTO
{
    private int rollno;
    private String name;
    private int yearofjoining;
    private double gpa;
    private String overallremarks;
    private List<CourseAnalysisDTO> courses;

}
