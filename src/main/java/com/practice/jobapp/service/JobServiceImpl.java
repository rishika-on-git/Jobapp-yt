package com.practice.jobapp.service;

import com.practice.jobapp.Job;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private List<Job> jobs = new ArrayList<Job>();

    @Override
    public List<Job> getJobs() {
        return jobs;
    }

    @Override
    public String addJob(Job job) {
        jobs.add(job);
        return "Job added successfully" + job.toString();
    }

}
