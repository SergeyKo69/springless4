package ru.kogut.enterprise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kogut.enterprise.model.Category;
import ru.kogut.enterprise.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void saveOrUpdate(Category category) {
        if (category == null) return;
        categoryRepository.save(category);
    }

    @Override
    public void delete(Category category) {
        if (category == null) return;
        categoryRepository.delete(category);
    }

    @Override
    public Category findById(String id) {
        if (id.isEmpty()) return null;
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        return categoryOptional.get();
     }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
