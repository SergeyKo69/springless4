package ru.kogut.enterprise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kogut.enterprise.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {
}
