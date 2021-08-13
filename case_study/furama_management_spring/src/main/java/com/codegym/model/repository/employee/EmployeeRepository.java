package com.codegym.model.repository.employee;

import com.codegym.model.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "select * from employee " +
            "where flag_del = 0", nativeQuery = true)
    List<Employee> findAllByFlagDel();

    @Query(value = "select * from employee " +
            "where flag_del = 0", nativeQuery = true)
    Page<Employee> findAllByFlagDel(Pageable pageable);

    @Query(value = "select * from employee " +
            "where flag_del = 0 and `name` like %:name% and id_card like %:idCard%", nativeQuery = true)
    Page<Employee> searchByNameAndIdCard(@Param("name") String name, @Param("idCard") String idCard, Pageable pageable);
}
