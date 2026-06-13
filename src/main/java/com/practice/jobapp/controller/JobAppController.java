package com.practice.jobapp.controller;


import com.practice.jobapp.Job;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    // We aren't using DB in this stage so we will maintain in memory state

    private List<Job> jobs = new ArrayList<>();

    @GetMapping()
    public List<Job> getJobs() {
        return jobs;
    }

    @PostMapping
    public String addJob(@RequestBody Job job) {
        jobs.add(job);
        return "Job added successfully" + job.toString();
    }



}
