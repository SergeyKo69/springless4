package ru.kogut.enterprise.service;

import ru.kogut.enterprise.model.Category;

import java.util.List;

public interface CategoryService {
    void saveOrUpdate(Category category);
    void delete(Category category);
    Category findById(String id);
    List<Category> findAll();
}
