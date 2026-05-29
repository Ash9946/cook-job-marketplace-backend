package com.example.cook_job_marketplace_backend.controller.user.JOB_PROVIDER;

import com.example.cook_job_marketplace_backend.entity.Job;
import com.example.cook_job_marketplace_backend.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
@RequiredArgsConstructor
public class JobController {

    private final JobService jobService;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_JOB_GIVER')")
    public Job createJob(@RequestBody Job job) {

        return jobService.createJob(job);
    }

    @GetMapping
    public List<Job> getAllJobs() {

        return jobService.getAllJobs();
    }

    @GetMapping("/{id}")
    public Job getJobById(@PathVariable Long id) {

        return jobService.getJobById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_JOB_GIVER')")
    public Job updateJob(
            @PathVariable Long id,
            @RequestBody Job job) {

        return jobService.updateJob(id, job);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public String deleteJob(@PathVariable Long id) {

        jobService.deleteJob(id);

        return "Job Deleted Successfully";
    }
}