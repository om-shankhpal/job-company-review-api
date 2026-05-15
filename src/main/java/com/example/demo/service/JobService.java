package com.example.demo.service;

import com.example.demo.model.Company;
import com.example.demo.model.Job;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobService {

    private final JobRepository jobRepository;
    private final CompanyRepository companyRepository;

    public List<Job> getAllJobs(){
        return jobRepository.findAll();
    }
    
    public void postJob(Job job){
        if(job.getCompany() == null){
            throw new RuntimeException("Company is required");
        }
        jobRepository.save(job);
    }

    public Job getJobById(Long id){
        return jobRepository.findById(id).orElse(null);
    }

    public void deleteJobById(Long id){
        jobRepository.deleteById(id);
    }
}
