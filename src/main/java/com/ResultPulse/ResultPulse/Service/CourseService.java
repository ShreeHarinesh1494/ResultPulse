package com.ResultPulse.ResultPulse.Service;

import com.ResultPulse.ResultPulse.DTO.Course.CourseDTO;
import com.ResultPulse.ResultPulse.Model.Course;
import com.ResultPulse.ResultPulse.Model.Sem;
import com.ResultPulse.ResultPulse.Repository.CourseRepo;
import com.ResultPulse.ResultPulse.Repository.SemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService
{

    @Autowired
    private CourseRepo cr;

    @Autowired
    private SemRepo sr;

    public String addcourse(CourseDTO coursedto) {
        Optional<Sem> sem = sr.findById(coursedto.getSemid());

        if (sem.isEmpty()) {
            return "Semester not found for ID: " + coursedto.getSemid();
        }

        Course course = new Course();
        course.setCourseid(coursedto.getCourseid());
        course.setCoursename(coursedto.getCoursename());
        course.setCredits(coursedto.getCredits());
        course.setSem(sem.get());

        cr.save(course);
        return "Course added successfully";
    }

    public List<Course> getall() {
        return (List<Course>) cr.findAll();
    }

    public Course getbyid(String courseid) {
        return cr.findById(courseid)
                .orElseThrow(() -> new RuntimeException("Course not found for ID: " + courseid));
    }
}
