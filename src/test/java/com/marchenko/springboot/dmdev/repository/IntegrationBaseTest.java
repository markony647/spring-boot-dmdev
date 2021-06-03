package com.marchenko.springboot.dmdev.repository;


import com.marchenko.springboot.dmdev.initializer.Postgres;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import javax.transaction.Transactional;

@ActiveProfiles("test")
@SpringBootTest
@ContextConfiguration(initializers = {
        Postgres.Initializer.class
})
@Transactional
public abstract class IntegrationBaseTest {

    @BeforeAll
    public static void init() {
        Postgres.container.start();
    }
}
