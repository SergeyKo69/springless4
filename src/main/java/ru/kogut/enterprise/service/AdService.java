package ru.kogut.enterprise.service;

import ru.kogut.enterprise.model.Ad;
import ru.kogut.enterprise.model.Category;

import java.util.List;

public interface AdService {
    void save(Ad ad);
    void delete(Ad ad);
    void update(Ad ad);
    Ad findById(String id);
    List<Ad> findAll();
    List<Ad> findAllByCategory(Category category);
}
