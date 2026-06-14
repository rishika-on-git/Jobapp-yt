package com.practice.jobapp.job;

import java.util.List;

public interface JobService {

    List<Job> getJobs();

    String addJob(Job job);

    Job getJobById(Long id);

    String deleteJobById(Long id);

    String updateJobById(Job job, Long id);

}
