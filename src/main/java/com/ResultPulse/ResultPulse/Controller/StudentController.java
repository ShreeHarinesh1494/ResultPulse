package com.ResultPulse.ResultPulse.Controller;

import com.ResultPulse.ResultPulse.DTO.Student.StudentDTO;
import com.ResultPulse.ResultPulse.DTO.Student.StudentLoginDTO;
import com.ResultPulse.ResultPulse.Model.Student;
import com.ResultPulse.ResultPulse.Service.StudentService;
import jakarta.persistence.PostLoad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/rp/admin/student")
public class StudentController
{
    @Autowired
    private StudentService ss;

    @PostMapping("/add")
    public String addstudent(@RequestBody StudentDTO studentDTO)
    {
        return ss.addstudent(studentDTO);
    }

    @GetMapping("/{rollno}")
    public Student getstudentbyid(@PathVariable int rollno)
    {
        return ss.getstudentbyid(rollno);
    }

    @PostMapping("/login")
    public String loginStudent(@RequestBody StudentLoginDTO dto) {
        return ss.loginStudent(dto);
    }


}
