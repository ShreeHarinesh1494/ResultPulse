package com.ResultPulse.ResultPulse.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adminid;
    private String adminname;
    private String email;
    private String password;

    @OneToMany(mappedBy = "createdby")
    private List<Topic> topics;
}
