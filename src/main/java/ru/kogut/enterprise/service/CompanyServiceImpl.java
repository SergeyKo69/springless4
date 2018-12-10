package ru.kogut.enterprise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kogut.enterprise.model.Company;
import ru.kogut.enterprise.repository.CompanyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public void saveOrUpdate(Company company) {
        if (company == null) return;
        companyRepository.save(company);
    }

    @Override
    public void delete(Company company) {
        if (company == null) return;
        companyRepository.delete(company);
    }

    @Override
    public Company findById(String id) {
        if (id.isEmpty()) return null;
        Optional<Company> companyOptional = companyRepository.findById(id);
        return companyOptional.get();
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }
}
