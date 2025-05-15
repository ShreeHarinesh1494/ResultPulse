package com.ResultPulse.ResultPulse.Service;


import com.ResultPulse.ResultPulse.DTO.Analysis.AnalysisDTO;
import com.ResultPulse.ResultPulse.DTO.CourseAnalysisDTO;
import com.ResultPulse.ResultPulse.Model.*;
import com.ResultPulse.ResultPulse.Repository.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AnalysisService
{
    @Autowired
    private AnalysisRepo ar;

    @Autowired
    private StudentRepo sr;

    @Autowired
    private CourseRepo cr;


    public String postdetails(AnalysisDTO analysisDTO) {
        // Fetch the student
        var student = sr.findById(analysisDTO.getRollno()).orElse(null);
        if (student == null) {
            return "Student not found!";
        }

        // Loop through courses and create Analysis entries for each course
        for (CourseAnalysisDTO courseDTO : analysisDTO.getCourses()) {
            // Create Analysis object for each course
            Analysis analysis = new Analysis();
            analysis.setStudent(student);
            analysis.setCourse(cr.findById(courseDTO.getCourseid()).orElse(null));  // Assuming course is fetched using courseid
            analysis.setAcquiredcredit(courseDTO.getAcquiredcredits());
            analysis.setGradepercourse(courseDTO.getGradepercourse());
            analysis.setOverallremarks(analysisDTO.getOverallremarks());
            analysis.setGpa(analysisDTO.getGpa());

            // You can implement custom logic to store the course remarks per subject
            analysis.setCourseRemarksJson(courseDTO.getCourseremark());

            // Save the analysis entry for the course
            ar.save(analysis);
        }

        return "Analysis details saved for student!";
    }

    public AnalysisDTO getbyid(int rollno) {
        // Get latest Analysis for a student
        List<Analysis> analyses = ar.findAll().stream()
                .filter(a -> a.getStudent().getRollno() == rollno)
                .collect(Collectors.toList());

        if (analyses.isEmpty()) return null;

        // Create AnalysisDTO and set data
        AnalysisDTO dto = new AnalysisDTO();
        dto.setRollno(analyses.get(0).getStudent().getRollno());
        dto.setName(analyses.get(0).getStudent().getName());
        dto.setYearofjoining(analyses.get(0).getStudent().getYearofjoining());
        dto.setGpa(analyses.get(0).getGpa());
        dto.setOverallremarks(analyses.get(0).getOverallremarks());

        // Set courses list from analyses
        List<CourseAnalysisDTO> courses = analyses.stream()
                .map(a -> new CourseAnalysisDTO(
                        a.getCourse().getCourseid(),
                        a.getCourse().getCoursename(),
                        a.getCourse().getCredits(),
                        a.getAcquiredcredit(),
                        a.getGradepercourse(),
                        a.getCourseRemarksJson()  // Add per course remarks here
                ))
                .collect(Collectors.toList());

        dto.setCourses(courses);

        return dto;
    }

}
