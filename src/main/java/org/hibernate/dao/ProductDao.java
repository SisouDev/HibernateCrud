package org.hibernate.dao;

import jakarta.persistence.EntityManager;
import org.hibernate.model.Product;
import org.hibernate.utils.JpaUtil;
import org.hibernate.utils.enums.PRODUCT_TYPE;

import java.util.List;
import java.util.function.Consumer;

public class ProductDao {

    public void updateProduct(Long id, Consumer<Product> updateFunction) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        try{
            entityManager.getTransaction().begin();
            Product product = entityManager.find(Product.class, id);
            updateFunction.accept(product);
            entityManager.merge(product);
            entityManager.getTransaction().commit();
        } catch(Exception e){
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw e;
        } finally {
            entityManager.close();
        }
    }

    public void updatePrice(Long id, Double newPrice) {
        updateProduct(id, product -> product.setPrice(newPrice));
    }

    public void updateName(Long id, String newName) {
        updateProduct(id, product -> product.setName(newName));
    }

    public void updateDescription(Long id, String newDescription) {
        updateProduct(id, product -> product.setDescription(newDescription));
    }

    public void updateType(Long id, PRODUCT_TYPE newType) {
        updateProduct(id, product -> product.setType(newType));
    }


}
