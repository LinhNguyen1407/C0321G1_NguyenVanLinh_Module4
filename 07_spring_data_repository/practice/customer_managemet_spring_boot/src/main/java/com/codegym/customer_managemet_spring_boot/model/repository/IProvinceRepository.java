package com.codegym.customer_managemet_spring_boot.model.repository;

import com.codegym.customer_managemet_spring_boot.model.bean.Province;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProvinceRepository extends PagingAndSortingRepository<Province, Long> {
}
