package com.ResultPulse.ResultPulse.Service;

import com.ResultPulse.ResultPulse.Model.Sem;
import com.ResultPulse.ResultPulse.Repository.SemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SemService
{
    @Autowired
    private SemRepo sr;

    public String postsemdetails(Sem sem) {
        if (sem.getSemname() == null || sem.getSemname().trim().isEmpty()) {
            return "Semester name cannot be empty.";
        }

        if (sr.existsBySemnameIgnoreCase(sem.getSemname().trim())) {
            return "Semester '" + sem.getSemname().trim() + "' already exists.";
        }

        sr.save(sem);
        return "Semester '" + sem.getSemname().trim() + "' saved successfully.";
    }

    public List<Sem> getall() {
        List<Sem> semList = (List<Sem>) sr.findAll();
        if (semList.isEmpty()) {
            throw new RuntimeException("No semesters found.");
        }
        return semList;
    }
}
