package com.practice.jobapp.job.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JobResponse {
    private Long id;
    private String title;
    private String description;
    private double minSalary;
    private double maxSalary;
    private String location;

    private Long companyId;
    private String companyName;
}