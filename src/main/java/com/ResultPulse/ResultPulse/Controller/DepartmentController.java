package com.ResultPulse.ResultPulse.Controller;


import com.ResultPulse.ResultPulse.Model.Department;
import com.ResultPulse.ResultPulse.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/rp/admin/dept")
public class DepartmentController {
    @Autowired
    private DepartmentService ds;

    @PostMapping("/post")
    public String postdept(@RequestBody Department dept) {
        return ds.postdept(dept);
    }

    @PostMapping("/postAll")
    public String postMultipleDepts(@RequestBody List<Department> departments) {
        return ds.postAllDepts(departments);
    }

    @GetMapping("all")
    public List<Department> getall() {
        return ds.getall();
    }

    @GetMapping("/{deptid}")
    public Department findbyid(@PathVariable int deptid) {
        return ds.getbyid(deptid);
    }
}
