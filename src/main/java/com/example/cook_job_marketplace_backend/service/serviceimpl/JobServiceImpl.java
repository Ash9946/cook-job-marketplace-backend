package com.example.cook_job_marketplace_backend.service.serviceimpl;

import com.example.cook_job_marketplace_backend.dto.response.JobRepository;
import com.example.cook_job_marketplace_backend.entity.Job;
import com.example.cook_job_marketplace_backend.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    @Override
    public Job createJob(Job job) {

        return jobRepository.save(job);
    }

    @Override
    public List<Job> getAllJobs() {

        return jobRepository.findAll();
    }

    @Override
    public Job getJobById(Long id) {

        return jobRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Job not found"));
    }

    @Override
    public Job updateJob(Long id, Job job) {

        Job existingJob = getJobById(id);

        existingJob.setTitle(job.getTitle());
        existingJob.setCompanyName(job.getCompanyName());
        existingJob.setLocation(job.getLocation());
        existingJob.setSalary(job.getSalary());
        existingJob.setExperience(job.getExperience());
        existingJob.setDescription(job.getDescription());
        existingJob.setSkills(job.getSkills());

        return jobRepository.save(existingJob);
    }

    @Override
    public void deleteJob(Long id) {

        jobRepository.deleteById(id);
    }
}