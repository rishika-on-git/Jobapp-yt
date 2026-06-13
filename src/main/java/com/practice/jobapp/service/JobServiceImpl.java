package com.practice.jobapp.service;

import com.practice.jobapp.Job;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private List<Job> jobs = new ArrayList<Job>();
    private Long nextId = 1L;

    @Override
    public List<Job> getJobs() {
        return jobs;
    }

    @Override
    public String addJob(Job job) {
        job.setId(nextId++);
        jobs.add(job);
        return "Job added successfully" + job.toString();
    }

    @Override
    public Job getJobById(Long id) {
        for (Job job : jobs) {
            if (job.getId().equals(id)) {
                return job;
            }
        }
        return null;
    }

    @Override
    public String deleteJobById(Long id) {
        for (Job job : jobs) {
            if (job.getId().equals(id)) {
                jobs.remove(job);
                return "Job deleted successfully";
            }
        }
        return null;
    }

}
