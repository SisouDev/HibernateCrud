package org.hibernate.dao;

import jakarta.persistence.EntityManager;
import org.hibernate.model.Product;
import org.hibernate.utils.JpaUtil;
import org.hibernate.utils.enums.PRODUCT_TYPE;

import java.util.List;

public class ProductDao {

    public void updatePrice(Long id, Double newPrice) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Product product = entityManager.find(Product.class, id);
        product.setPrice(newPrice);
        entityManager.merge(product);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void updateName(Long id, String newName) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Product product = entityManager.find(Product.class, id);
        product.setName(newName);
        entityManager.merge(product);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void updateDescription(Long id, String newDescription) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Product product = entityManager.find(Product.class, id);
        product.setDescription(newDescription);
        entityManager.merge(product);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void updateType(Long id, PRODUCT_TYPE newType) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Product product = entityManager.find(Product.class, id);
        product.setType(newType);
        entityManager.merge(product);
        entityManager.getTransaction().commit();
        entityManager.close();
    }


}
