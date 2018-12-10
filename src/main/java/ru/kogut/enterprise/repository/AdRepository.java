package ru.kogut.enterprise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kogut.enterprise.model.Ad;

import java.util.List;

@Repository
public interface AdRepository extends JpaRepository<Ad, String> {
    List<Ad> findAdByCategory_Id(String categoryId);
}
