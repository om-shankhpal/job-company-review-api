package com.example.demo.service;

import com.example.demo.model.Company;
import com.example.demo.model.Job;
import com.example.demo.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    public List<Company> getAllCompanies(){
        return companyRepository.findAll();
    }

    public void postCompany(Company company){
        if(company.getJobs() != null){
            for(Job job : company.getJobs()){
                job.setCompany(company);
            }
        }
        companyRepository.save(company);
    }

    public Company getCompanyById(Long id){
        return companyRepository.findById(id).orElse(null);
    }

    public void deleteCompanyById(Long id){
        companyRepository.deleteById(id);
    }
}
