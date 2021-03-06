package com.codegym.model.repository;

import com.codegym.model.bean.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CustomerRepository implements ICustomerRepository {

    @Override
    public void insertWithStoredProcedure(Customer customer) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        String sql = "CALL Insert_Customer(:firstName, :lastName)";
        Query query = BaseRepository.entityManager.createNativeQuery(sql);
        query.setParameter("firstName", customer.getFirstName());
        query.setParameter("lastName", customer.getLastName());
        query.executeUpdate();
        transaction.commit();
    }

    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> query = BaseRepository.entityManager.createQuery("select c from Customer c", Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer findById(Long id) {
        TypedQuery<Customer> query = BaseRepository.entityManager.createQuery("select c from Customer c where  c.id=:id", Customer.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void save(Customer customer) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        if (customer.getId() != null) {
            BaseRepository.entityManager.merge(customer);
        } else {
            BaseRepository.entityManager.persist(customer);
        }
        transaction.commit();
    }

    @Override
    public void remove(Long id) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        Customer customer = findById(id);
        if (customer != null) {
            BaseRepository.entityManager.remove(customer);
        }
        transaction.commit();
    }
}