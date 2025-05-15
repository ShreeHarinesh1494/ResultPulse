package com.ResultPulse.ResultPulse.Controller;

import com.ResultPulse.ResultPulse.DTO.Analysis.AnalysisDTO;
import com.ResultPulse.ResultPulse.Service.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/rp/analysis")
public class AnalysisController
{
    @Autowired
    private AnalysisService as;

    @PostMapping("/post")
    public String postdetails(@RequestBody AnalysisDTO analysisdto)
    {
        return as.postdetails(analysisdto);
    }

    @GetMapping("{rollno}")
    public AnalysisDTO getbyid(@PathVariable int rollno)
    {
        return as.getbyid(rollno);
    }
}
