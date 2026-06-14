package com.practice.jobapp.job.mapper;

import com.practice.jobapp.job.Job;
import com.practice.jobapp.job.dto.request.CreateJobRequest;
import com.practice.jobapp.job.dto.response.JobResponse;

public class JobMapper {

    public static Job toEntity(CreateJobRequest request) {

        Job job = new Job();

        job.setTitle(request.getTitle());
        job.setDescription(request.getDescription());
        job.setLocation(request.getLocation());
        job.setMinSalary(request.getMinSalary());
        job.setMaxSalary(request.getMaxSalary());

        return job;
    }

    public static JobResponse toResponse(Job job) {

        JobResponse response = new JobResponse();

        response.setId(job.getId());
        response.setTitle(job.getTitle());
        response.setDescription(job.getDescription());
        response.setLocation(job.getLocation());
        response.setMinSalary(job.getMinSalary());
        response.setMaxSalary(job.getMaxSalary());

        return response;
    }
}