package com.practice.jobapp.job.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateJobRequest {
    private String title;
    private String description;
    private double minSalary;
    private double maxSalary;
    private String location;
}
