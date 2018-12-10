package ru.kogut.enterprise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kogut.enterprise.model.Category;
import ru.kogut.enterprise.repository.CategoryRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService{

    private Map<String, Category> listMap = new HashMap<>();

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void save(Category category) {
        if (category == null) return;
        categoryRepository.save(category);
    }

    @Override
    public void delete(Category category) {
        if (category == null) return;
        categoryRepository.delete(category);
    }

    @Override
    public void update(Category category) {
        if (category == null) return;
        Category categoruToUpdate = categoryRepository.getOne(category.getId());
        if (categoruToUpdate == null) return;
        categoruToUpdate.setName(category.getName());
        categoryRepository.save(categoruToUpdate);
    }

    @Override
    public Category findById(String id) {
        if (id.isEmpty()) return null;
        Category category = listMap.get(id);
        if (category == null){
            category = categoryRepository.getOne(id);
            if (category != null){
                listMap.put(category.getId(), category);
            }
        }
        return category;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
