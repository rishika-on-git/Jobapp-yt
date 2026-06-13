package com.practice.jobapp.service;

import com.practice.jobapp.Job;

import java.util.List;

public interface JobService {

    List<Job> getJobs();

    String addJob(Job job);

    Job getJobById(Long id);

}
