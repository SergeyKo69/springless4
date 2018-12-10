package ru.kogut;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.kogut.enterprise.configuration.ApplicationConfiguration;
import ru.kogut.enterprise.model.Ad;
import ru.kogut.enterprise.model.Category;
import ru.kogut.enterprise.model.Company;
import ru.kogut.enterprise.service.AdServiceImpl;
import ru.kogut.enterprise.service.CategoryServiceImpl;
import ru.kogut.enterprise.service.CompanyServiceImpl;

public class MainTest {

    @Test
    public void Test() {
        final ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        final CompanyServiceImpl companyService = ctx.getBean(CompanyServiceImpl.class);
        final CategoryServiceImpl categoryService = ctx.getBean(CategoryServiceImpl.class);
        final AdServiceImpl adService = ctx.getBean(AdServiceImpl.class);

        Company company = new Company();
        company.setName("ООО Рога и копыта");
        company.setDescription("Хорошая компания");
        company.setAddress("г. Москва");
        companyService.saveOrUpdate(company);
        Category category = new Category();
        category.setName("New category");
        categoryService.saveOrUpdate(category);
        Ad ad = new Ad();
        ad.setBody("body ad");
        ad.setCategory(category);
        ad.setCompany(company);
        ad.setPhone("+79007777777");
        ad.setTitle("title ad");

        adService.saveOrUpdate(ad);
        Assert.assertNotNull(adService.findById(ad.getId()));

        ad.setTitle("title ad2");
        adService.saveOrUpdate(ad);

        Ad adTemp = adService.findById(ad.getId());
        Assert.assertEquals(ad.getTitle(),adTemp.getTitle());
        Assert.assertTrue(adService.findAllByCategory(category).size() > 0);

        adService.delete(ad);
        categoryService.delete(category);
        companyService.delete(company);
    }

}
