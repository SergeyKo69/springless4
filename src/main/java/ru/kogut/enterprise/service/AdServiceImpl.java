package ru.kogut.enterprise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kogut.enterprise.model.Ad;
import ru.kogut.enterprise.model.Category;
import ru.kogut.enterprise.repository.AdRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AdServiceImpl implements AdService {

    private Map<String, Ad> listMap = new HashMap<>();

    @Autowired
    private AdRepository adRepository;

    @Override
    public void save(Ad ad) {
        if (ad == null) return;
        adRepository.save(ad);
    }

    @Override
    public void delete(Ad ad) {
        if (ad == null) return;
        adRepository.delete(ad);
    }

    @Override
    public void update(Ad ad) {
        if (ad == null) return;
        Optional<Ad> optionalAd = adRepository.findById(ad.getId());
        Ad adToUpdate = optionalAd.get();
        if (adToUpdate == null) return;
        adToUpdate.setId(ad.getId());
        adToUpdate.setTitle(ad.getTitle());
        adToUpdate.setPhone(ad.getPhone());
        adToUpdate.setCompany(ad.getCompany());
        adToUpdate.setCategory(ad.getCategory());
        adToUpdate.setBody(ad.getBody());
        adRepository.save(adToUpdate);
    }

    @Override
    public Ad findById(String id) {
        if (id.isEmpty()) return null;
        Ad ad = listMap.get(id);
        if (ad == null){
            Optional<Ad> adOptional = adRepository.findById(id);
            ad = adOptional.get();
            if (ad != null){
                listMap.put(ad.getId(), ad);
            }
        }
        return ad;
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
