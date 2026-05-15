package com.example.demo.controller;

import com.example.demo.model.Company;
import com.example.demo.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies(){
        return ResponseEntity.ok(companyService.getAllCompanies());
    }

    @PostMapping
    public ResponseEntity<String> postCompany(@RequestBody Company company){
        companyService.postCompany(company);
        return ResponseEntity.ok("Company Added Successfully.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {
        if (companyService.getCompanyById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(companyService.getCompanyById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompanyById(@PathVariable Long id) {
        if (companyService.getCompanyById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Company Deleted Successfully.");
    }
}
