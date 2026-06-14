package com.practice.jobapp.job.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateJobRequest {
    private String title;
    private String description;
    private double minSalary;
    private double maxSalary;
    private String location;
}