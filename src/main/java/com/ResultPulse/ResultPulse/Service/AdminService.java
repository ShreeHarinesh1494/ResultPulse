package com.ResultPulse.ResultPulse.Service;


import com.ResultPulse.ResultPulse.Model.Admin;
import com.ResultPulse.ResultPulse.Repository.AdminRepo;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class AdminService
{

    @Autowired
    private AdminRepo ar;

    @Autowired
    private JavaMailSender mailSender;

    private Map<String, String> otpMap = new HashMap<>();

    public String register(Admin admin)
    {
        if (ar.findByEmail(admin.getEmail()) != null) {
            return "Email is already registered!";
        }

        ar.save(admin);
        return "Admin Registered Successfully";
    }


    public String login(String email, String password)
    {
        Admin admin = ar.findByEmail((email));
        if (admin == null) {
            return "Admin not found!";
        }

        if (!admin.getPassword().equals(password)) {
            return "Invalid credentials!";
        }

        String otp = generateOtp();
        otpMap.put(email, otp); // save to map

        sendOtpEmail(email, otp);

        return "OTP sent to your email!";
    }

    public ResponseEntity<Map<String, Object>> verifyOtp(String email, String otp) {
        String storedOtp = otpMap.get(email);
        Map<String, Object> response = new HashMap<>();

        if (storedOtp != null && storedOtp.equals(otp)) {
            otpMap.remove(email);

            Admin admin = ar.findByEmail(email); // get the admin
            if (admin != null) {
                response.put("message", "Login successful!");
                response.put("adminId", admin.getAdminid());
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.put("message", "Admin not found!");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }

        } else {
            response.put("message", "Invalid OTP!");
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        }
    }

    private String generateOtp() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
    }

    public void sendOtpEmail(String toEmail, String otp) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("shreeharineshs@gmail.com");
            helper.setTo(toEmail);
            helper.setSubject("OTP for Login");
            helper.setText("Your OTP is: " + otp);

            mailSender.send(message); // Send the email
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
