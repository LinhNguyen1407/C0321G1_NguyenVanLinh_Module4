package com.codegym.blog_application.model.repository;

import com.codegym.blog_application.model.entity.Category;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {
}
