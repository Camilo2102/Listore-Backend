package com.example.listore.repository;

import com.example.listore.dto.CompanyFilterDTO;
import com.example.listore.models.Company;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends GeneralRepository<Company> {
}
