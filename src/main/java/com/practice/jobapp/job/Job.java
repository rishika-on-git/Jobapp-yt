package com.practice.jobapp.job;

import com.practice.jobapp.company.Company;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private double minSalary;
    private double maxSalary;
    private String location;

    @ManyToOne
    private Company company;
    //now every job row will store a company_id

}
