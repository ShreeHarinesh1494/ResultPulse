package com.ResultPulse.ResultPulse.Controller;

import com.ResultPulse.ResultPulse.DTO.Course.CourseDTO;
import com.ResultPulse.ResultPulse.Model.Course;
import com.ResultPulse.ResultPulse.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/rp/admin/course")
public class CourseController
{
    @Autowired
    private CourseService cs;

    @PostMapping("/add")
    public String courseadd(@RequestBody CourseDTO coursedto)
    {
        return cs.addcourse(coursedto);
    }

    @GetMapping("/getall")
    public List<Course> getall()
    {
        return cs.getall();
    }

    @GetMapping("/{courseid}")
    public Course getbyid(@PathVariable String courseid)
    {
        return cs.getbyid(courseid);
    }

}
