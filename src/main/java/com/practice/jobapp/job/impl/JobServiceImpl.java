package com.practice.jobapp.job.impl;

import com.practice.jobapp.company.Company;
import com.practice.jobapp.company.CompanyRepository;
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
    private final CompanyRepository companyRepository;

    public JobServiceImpl(JobRepository jobRepository, CompanyRepository companyRepository) {
        this.jobRepository = jobRepository;
        this.companyRepository = companyRepository;
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

        Company company = companyRepository.findById(request.getCompanyId())
                        .orElseThrow(() -> new RuntimeException("Company not found"));

        Job job = JobMapper.toEntity(request);

        job.setCompany(company);

        Job savedJob = jobRepository.save(job);
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

        Job existingJob = jobRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Job not found"));

        Company company = companyRepository.findById(request.getCompanyId())
                .orElseThrow(() -> new RuntimeException("Company not found"));

        existingJob.setTitle(request.getTitle());
        existingJob.setDescription(request.getDescription());
        existingJob.setLocation(request.getLocation());
        existingJob.setMinSalary(request.getMinSalary());
        existingJob.setMaxSalary(request.getMaxSalary());

        existingJob.setCompany(company);

        Job updatedJob = jobRepository.save(existingJob);

        return JobMapper.toResponse(updatedJob);
    }
}