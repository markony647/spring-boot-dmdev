package com.marchenko.springboot.dmdev.repository;

import com.marchenko.springboot.dmdev.entity.EmployeeEntity;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class EmployeeCustomRepositoryImpl implements EmployeeCustomRepository {

    private final EntityManager entityManager;

    @Override
    public List<EmployeeEntity> findCustomQuery() {
        return new ArrayList<>();
    }
}
