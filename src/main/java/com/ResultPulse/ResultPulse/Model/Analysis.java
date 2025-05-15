package com.ResultPulse.ResultPulse.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Analysis
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int analysisid;

    @ManyToOne
    private Student student;
    @ManyToOne
    private Course course;
    @ManyToOne
    private Department department;
    @ManyToOne
    private Sem sem;

    private int acquiredcredit;
    private double gpa;
    private String gradepercourse;
    private String overallremarks;
    @Lob
    private String courseRemarksJson;

}
