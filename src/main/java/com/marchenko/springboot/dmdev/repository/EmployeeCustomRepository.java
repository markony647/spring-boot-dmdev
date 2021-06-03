package com.marchenko.springboot.dmdev.repository;

import com.marchenko.springboot.dmdev.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeCustomRepository {

    List<EmployeeEntity> findCustomQuery();
}
