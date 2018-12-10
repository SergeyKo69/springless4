package ru.kogut.enterprise.service;

import ru.kogut.enterprise.model.Company;

import java.util.List;

public interface CompanyService {
    void saveOrUpdate(Company company);
    void delete(Company company);
    Company findById(String id);
    List<Company> findAll();
}
