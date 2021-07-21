package com.codegym.model.repository;

import com.codegym.model.bean.Blog;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.util.List;

@Repository
public class BlogRepositoryImpl implements BlogRepository {
    @Override
    public List<Blog> findAll() {
        return BaseRepository.entityManager.createQuery(
                "select b from Blog as b", Blog.class).getResultList();
    }

    @Override
    public void save(Blog blog) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        if (blog.getId() != null) {
            BaseRepository.entityManager.merge(blog);
        } else {
            BaseRepository.entityManager.persist(blog);
        }
        transaction.commit();
    }

    @Override
    public Blog findById(Integer id) {
        return BaseRepository.entityManager.find(Blog.class, id);
    }

//    @Override
//    public void update(Blog blog) {
//        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
//        transaction.begin();
//        BaseRepository.entityManager.merge(blog);
//        transaction.commit();
//    }

    @Override
    public void remove(Integer id) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        Blog blog = findById(id);
        if (blog != null) {
            BaseRepository.entityManager.remove(blog);
        }
        transaction.commit();
    }
}
