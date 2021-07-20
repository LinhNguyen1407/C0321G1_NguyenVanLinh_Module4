package com.codegym.model.repository;

import com.codegym.model.bean.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Override
    public List<Product> findAll() {
        String queryStr = "SELECT product FROM Product AS product";
        TypedQuery<Product> query = BaseRepository.entityManager.createQuery(queryStr, Product.class);
        return query.getResultList();
    }

    @Override
    public void save(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = BaseRepository.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Product findById(int id) {
        String queryStr = "SELECT product FROM Product AS product WHERE product.id = :id";
        TypedQuery<Product> query = BaseRepository.entityManager.createQuery(queryStr, Product.class);
        query.setParameter("id", id);
        return query.getSingleResult();

    }

    @Override
    public void update(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = BaseRepository.sessionFactory.openSession();
            transaction = session.beginTransaction();
            Product origin = findById(product.getId());
            origin.setName(product.getName());
            origin.setPrice(product.getPrice());
            origin.setDescription(product.getDescription());
            origin.setManufacturer(product.getManufacturer());
            session.update(origin);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void remove(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = BaseRepository.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.remove(product);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
