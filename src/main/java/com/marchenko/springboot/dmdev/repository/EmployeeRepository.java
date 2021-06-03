package com.marchenko.springboot.dmdev.repository;

import com.marchenko.springboot.dmdev.entity.EmployeeEntity;
import com.marchenko.springboot.dmdev.projection.EmployeeNameView;
import com.marchenko.springboot.dmdev.projection.EmployeeNativeView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer>, EmployeeCustomRepository {

    Optional<EmployeeEntity> findByFirstNameContaining(String firstName);

    @Query("select e from EmployeeEntity e where e.firstName = ?1 and e.salary = ?2")
    List<EmployeeEntity> findByFirstNameAndSalary(String firstName, Integer salary);

    List<EmployeeNameView> findAllBySalaryGreaterThan(Integer salary);

    @Query(value = "select " +
            "e.id as id, " +
            "e.first_name || e.last_name as fullName " +
            "from employee e " +
            "where  e.salary > :salary", nativeQuery = true)
    List<EmployeeNativeView> findAllBySalaryGreaterNative(@Param("salary") Integer salary);
}
