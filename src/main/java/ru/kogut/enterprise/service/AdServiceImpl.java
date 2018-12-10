package ru.kogut.enterprise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kogut.enterprise.model.Ad;
import ru.kogut.enterprise.model.Category;
import ru.kogut.enterprise.repository.AdRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AdServiceImpl implements AdService {

    @Autowired
    private AdRepository adRepository;

    @Override
    public void saveOrUpdate(Ad ad) {
        if (ad == null) return;
        adRepository.save(ad);
    }

    @Override
    public void delete(Ad ad) {
        if (ad == null) return;
        adRepository.delete(ad);
    }

    @Override
    public Ad findById(String id) {
        if (id.isEmpty()) return null;
        Optional<Ad> adOptional = adRepository.findById(id);
        return adOptional.get();
    }

    @Override
    public List<Ad> findAll() {
        return adRepository.findAll();
    }

    @Override
    public List<Ad> findAllByCategory(Category category) {
        return adRepository.findAdByCategory_Id(category.getId());
    }
}
