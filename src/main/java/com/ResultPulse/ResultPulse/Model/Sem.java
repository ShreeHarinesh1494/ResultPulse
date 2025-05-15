package com.ResultPulse.ResultPulse.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Sem
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int semid;
    private String semname;
}
