package com.practice.jobapp.repository;

import com.practice.jobapp.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {

}
