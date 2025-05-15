package com.ResultPulse.ResultPulse.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course
{
    @Id
    private String courseid;
    private String coursename;
    private int credits;

    @ManyToOne
    private Sem sem;
}
