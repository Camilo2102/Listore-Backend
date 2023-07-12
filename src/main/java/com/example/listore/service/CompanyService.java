package com.example.listore.service;

import com.example.listore.dto.CompanyFilterDTO;
import com.example.listore.models.Company;
import com.example.listore.repository.CompanyRepository;
import com.example.listore.repository.GeneralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("CompanyService")
public class CompanyService extends GeneralService<Company> {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        super(companyRepository);
        this.companyRepository = companyRepository;
    }
}
