package com.codegym.blog_application.model.repository;

import com.codegym.blog_application.model.entity.Blog;
import com.codegym.blog_application.model.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends PagingAndSortingRepository<Blog, Long> {

    Iterable<Blog> findAllByCategory(Category category);

    Page<Blog> findAllByTitleContaining(String name, Pageable pageable);
}

