package com.practice.jobapp.controller;


import com.practice.jobapp.Job;
import com.practice.jobapp.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/*
GET /jobs: Get all jobs
GET /jobs/{id}: Get a specific job by ID
POST /jobs: Create a new job (request body should contain the job details)
DELETE /jobs/{id}: Delete a specific job by ID
PUT /jobs/{id}: Update a specific job by ID (request body should contain the updated job)

Example API URLs:

GET {base_url}/jobs
GET {base_url}/jobs/1
POST {base_url}/jobs
DELETE {base_url}/jobs/1
PUT {base_url}/jobs/1
*/

@RestController
@RequestMapping("/api/v1/jobs")
public class JobAppController {

    private final JobService jobService;

    public JobAppController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping()
    public ResponseEntity<List<Job>> getJobs() {
        List<Job> jobs = jobService.getJobs();
        return new ResponseEntity<>(jobs , HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addJob(@RequestBody Job job) {
        String result = jobService.addJob(job);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
        Job job = jobService.getJobById(id);
        if(job == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(job, HttpStatus.OK);
    }

}
