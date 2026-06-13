package com.practice.jobapp;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Job {
    private Long id;
    private String title;
    private String description;
    private double minSalary;
    private double maxSalary;
    private String location;

}
