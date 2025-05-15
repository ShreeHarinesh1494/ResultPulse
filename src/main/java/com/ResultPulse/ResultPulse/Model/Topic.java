package com.ResultPulse.ResultPulse.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Topic
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int topicid;
    private String topicname;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "created_by", referencedColumnName = "adminid")
    private Admin createdby;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime creationdate;
}
