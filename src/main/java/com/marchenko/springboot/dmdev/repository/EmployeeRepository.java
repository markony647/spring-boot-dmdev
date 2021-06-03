package com.marchenko.springboot.dmdev.repository;

import com.marchenko.springboot.dmdev.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

    Optional<EmployeeEntity> findByFirstNameContaining(String firstName);

    @Query("select e from EmployeeEntity e where e.firstName = ?1 and e.salary = ?2")
    List<EmployeeEntity> findByFirstNameAndSalary(String firstName, Integer salary);
}
