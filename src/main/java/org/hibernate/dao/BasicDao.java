package org.hibernate.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.hibernate.utils.JpaUtil;

import java.util.List;

public class BasicDao <T>{
    private Class<T> entityClass;

    public BasicDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public T create(T t) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(t);
        entityManager.getTransaction().commit();
        entityManager.close();
        return t;
    }

    public T findById(Long id) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        T entity = entityManager.find(entityClass, id);
        entityManager.close();
        return entity;
    }

    public List<T> findAll() {
        EntityManager entityManager = JpaUtil.getEntityManager();
        String jpql = "SELECT DISTINCT t FROM " + entityClass.getSimpleName() + " t LEFT JOIN FETCH t.products";
        Query query = entityManager.createQuery(jpql);
        query.setMaxResults(5);
        List<T> list = query.getResultList();
        entityManager.close();
        return list;
    }

    public void removeById(Long id) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        T entity = entityManager.find(entityClass, id);
        if (entity != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(entity);
            entityManager.getTransaction().commit();
        }
        entityManager.close();
    }
}
