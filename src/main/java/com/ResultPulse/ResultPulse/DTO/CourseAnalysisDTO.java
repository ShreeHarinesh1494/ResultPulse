package com.ResultPulse.ResultPulse.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseAnalysisDTO
{
    private String courseid;
    private String coursename;
    private int credits;
    private int acquiredcredits;
    private String gradepercourse;
    private String courseremark;
}
