package com.practice.jobapp.controller;


import com.practice.jobapp.Job;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/jobs")
public class JobAppController {

    // We aren't using DB in this stage so we will maintain in memory state

    private List<Job> jobs = new ArrayList<>();

    @GetMapping()
    public List<Job> getJobs() {
        return jobs;
    }

}
