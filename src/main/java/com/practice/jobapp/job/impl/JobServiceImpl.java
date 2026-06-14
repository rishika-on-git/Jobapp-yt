package com.practice.jobapp.job.impl;

import com.practice.jobapp.job.Job;
import com.practice.jobapp.job.JobRepository;
import com.practice.jobapp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;
    //This dependency should never change after construction.

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> getJobs() {
        return jobRepository.findAll();
    }

    @Override
    public Job addJob(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {
        Optional<Job> result = jobRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new RuntimeException("Job not found");
    }

    @Override
    public void deleteJobById(Long id) {

        if (!jobRepository.existsById(id)) {
            throw new RuntimeException("Job not found");
        }
        jobRepository.deleteById(id);
    }

    @Override
    public Job updateJobById(Job job, Long id) {

        Optional<Job> result = jobRepository.findById(id);

        if (result.isEmpty()) {
            throw new RuntimeException("Job not found");
        }

        Job existingJob = result.get();

        existingJob.setTitle(job.getTitle());
        existingJob.setDescription(job.getDescription());
        existingJob.setLocation(job.getLocation());
        existingJob.setMinSalary(job.getMinSalary());
        existingJob.setMaxSalary(job.getMaxSalary());

        return jobRepository.save(existingJob);
    }

}
