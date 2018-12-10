package ru.kogut.enterprise.service;

import ru.kogut.enterprise.model.Category;

import java.util.List;

public interface CategoryService {
    void save(Category category);
    void delete(Category category);
    void update(Category category);
    Category findById(String id);
    List<Category> findAll();
}
