package com.marchenko.springboot.dmdev.repository;

import com.marchenko.springboot.dmdev.entity.CompanyEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


class CompanyRepositoryTest extends IntegrationBaseTest {

    private static final Integer APPLE_ID = 1;

    @Autowired
    private CompanyRepository companyRepository;

    @Test
    void testGetById() {
        Optional<CompanyEntity> apple = companyRepository.findById(APPLE_ID);
        assertTrue(apple.isPresent());
        apple.ifPresent(entity -> {
            assertEquals("Apple", entity.getName());
        });
    }

    @Test
    void testSave() {
        CompanyEntity company = CompanyEntity.builder()
                .name("FitBit")
                .build();
        companyRepository.save(company);
        assertNotNull(company.getId());
    }
}