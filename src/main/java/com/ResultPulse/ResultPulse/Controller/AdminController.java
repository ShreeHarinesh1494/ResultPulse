package com.ResultPulse.ResultPulse.Controller;


import com.ResultPulse.ResultPulse.DTO.Admin.LoginRequest;
import com.ResultPulse.ResultPulse.Model.Admin;
import com.ResultPulse.ResultPulse.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/rp/admin")
public class AdminController
{
    @Autowired
    private AdminService as;

    @PostMapping("/register")
    public String register(@RequestBody Admin admin)
    {
        return as.register(admin);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request)
    {
        return as.login(request.getEmail(), request.getPassword());
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<?> verifyOtp(@RequestBody Map<String, String> payload) {
        String email = payload.get("email");
        String otp = payload.get("otp");
        return as.verifyOtp(email, otp);
    }

}
