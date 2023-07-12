package com.example.listore.controller;

import com.example.listore.dto.CompanyFilterDTO;
import com.example.listore.models.Company;
import com.example.listore.service.CompanyService;
import com.example.listore.utils.EncryptUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
@Transactional
public class CompanyController extends GeneralController<Company> {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        super(companyService);
        this.companyService = companyService;
    }
    
}
