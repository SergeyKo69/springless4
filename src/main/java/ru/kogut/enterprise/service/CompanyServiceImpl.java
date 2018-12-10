package ru.kogut.enterprise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kogut.enterprise.model.Company;
import ru.kogut.enterprise.repository.CompanyRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CompanyServiceImpl implements CompanyService {

    private Map<String, Company> listMap = new HashMap<>();

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public void save(Company company) {
        if (company == null) return;
        companyRepository.save(company);
    }

    @Override
    public void delete(Company company) {
        if (company == null) return;
        companyRepository.delete(company);
    }

    @Override
    public void update(Company company) {
        if (company == null) return;
        Company companyToUpdate = companyRepository.getOne(company.getId());
        if (companyToUpdate == null) return;
        companyToUpdate.setName(company.getName());
        companyToUpdate.setAddress(company.getAddress());
        companyToUpdate.setDescription(company.getDescription());
        companyRepository.save(companyToUpdate);
    }

    @Override
    public Company findById(String id) {
        if (id.isEmpty()) return null;
        Company company = listMap.get(id);
        if (company == null) {
            company = companyRepository.getOne(id);
            if (company != null) {
                listMap.put(company.getId(), company);
            }
        }
        return company;
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }
}
