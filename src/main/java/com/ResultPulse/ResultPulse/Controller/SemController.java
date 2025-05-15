package com.ResultPulse.ResultPulse.Controller;

import com.ResultPulse.ResultPulse.Model.Sem;
import com.ResultPulse.ResultPulse.Service.SemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/rp/admin/sem")
public class SemController
{
    @Autowired
    private SemService ss;

    @PostMapping("/add")
    public String postsemdetails(@RequestBody Sem sem)
    {
        return ss.postsemdetails(sem);
    }

    @GetMapping("/getall")
    public List<Sem> getall()
    {
        return ss.getall();
    }
}
