package com.practice.jobapp.job;

import com.practice.jobapp.job.dto.request.CreateJobRequest;
import com.practice.jobapp.job.dto.response.JobResponse;

import java.util.List;

public interface JobService {

    List<JobResponse> getJobs();

    JobResponse addJob(CreateJobRequest job);

    JobResponse getJobById(Long id);

    void deleteJobById(Long id);

    JobResponse updateJobById(CreateJobRequest job, Long id);

}
