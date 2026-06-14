package com.practice.jobapp.job;

import java.util.List;

public interface JobService {

    List<Job> getJobs();

    Job addJob(Job job);

    Job getJobById(Long id);

    void deleteJobById(Long id);

    Job updateJobById(Job job, Long id);

}
