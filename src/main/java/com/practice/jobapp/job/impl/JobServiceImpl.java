package com.practice.jobapp.job.impl;

import com.practice.jobapp.job.Job;
import com.practice.jobapp.job.JobRepository;
import com.practice.jobapp.job.JobService;
import com.practice.jobapp.job.dto.request.CreateJobRequest;
import com.practice.jobapp.job.dto.response.JobResponse;
import com.practice.jobapp.job.mapper.JobMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<JobResponse> getJobs() {

        return jobRepository.findAll()
                .stream()
                .map(JobMapper::toResponse)
                .toList();
    }

    @Override
    public JobResponse addJob(CreateJobRequest request) {

        Job entity = JobMapper.toEntity(request);

        Job savedJob = jobRepository.save(entity);

        return JobMapper.toResponse(savedJob);
    }

    @Override
    public JobResponse getJobById(Long id) {

        Optional<Job> result = jobRepository.findById(id);

        if (result.isPresent()) {
            return JobMapper.toResponse(result.get());
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
    public JobResponse updateJobById(CreateJobRequest request, Long id) {

        Optional<Job> result = jobRepository.findById(id);

        if (result.isEmpty()) {
            throw new RuntimeException("Job not found");
        }

        Job existingJob = result.get();

        existingJob.setTitle(request.getTitle());
        existingJob.setDescription(request.getDescription());
        existingJob.setLocation(request.getLocation());
        existingJob.setMinSalary(request.getMinSalary());
        existingJob.setMaxSalary(request.getMaxSalary());

        Job updatedJob = jobRepository.save(existingJob);

        return JobMapper.toResponse(updatedJob);
    }
}