package com.example.demo.controller;

import com.example.demo.model.Job;
import com.example.demo.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
@RequiredArgsConstructor
public class JobController {
    private final JobService jobService;

    @GetMapping
    public ResponseEntity<List<Job>> getAllJob(){
        return ResponseEntity.ok(jobService.getAllJobs());
    }

    @PostMapping
    public ResponseEntity<String> postJob(@RequestBody Job job){
        jobService.postJob(job);
        return ResponseEntity.ok("Job Added Successfully.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        if (jobService.getJobById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(jobService.getJobById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id){
        if (jobService.getJobById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        jobService.deleteJobById(id);
        return ResponseEntity.ok("Job Deleted Successfully.");
    }
}
