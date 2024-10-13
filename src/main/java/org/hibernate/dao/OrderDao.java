package org.hibernate.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.hibernate.model.Order;
import org.hibernate.model.Product;
import org.hibernate.utils.JpaUtil;

import java.util.List;

public class OrderDao {
    public Order createOrder(Order order) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(order);
        entityManager.getTransaction().commit();
        entityManager.close();
        return order;
    }

    public Order getOrderById(EntityManager entityManager, Long orderId){
        Order order = entityManager.find(Order.class, orderId);
        if (order == null) {
            entityManager.close();
            throw new IllegalArgumentException("Order does not exist");
        }
        return order;
    }

    public void addProductsById(Long orderId, List<Long> productIds) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Order order = getOrderById(entityManager, orderId);

        for (Long productId : productIds) {
            Product product = entityManager.find(Product.class, productId);
            if (product != null) {
                if(!order.getProducts().contains(product)) {
                    order.getProducts().add(product);
                }
            }else {
                System.out.println("Product with id: " + productId + " does not exist.");
            }
        }

        order.setTotalQuantity(order.getProducts().size());
        order.setTotalPrice(order.getTotalPrice());
        entityManager.merge(order);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void addProducts(Long orderId, List<Product> products) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Order order = getOrderById(entityManager, orderId);

        for (Product product : products) {
            if (!order.getProducts().contains(product)){
                order.getProducts().add(product);
            } else {
                System.out.println("Product with id: " + product.getId() + " already exists.");
            }
        }

        order.setTotalQuantity(order.getProducts().size());
        order.setTotalPrice(order.getTotalPrice());
        entityManager.merge(order);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void removeProductsById(Long orderId, List<Long> productIds) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Order order = getOrderById(entityManager, orderId);
        for (Long productId : productIds) {
            Product product = entityManager.find(Product.class, productId);
            if (product != null) {
                order.getProducts().remove(product);
            }else {
                System.out.println("Product with id: " + productId + " does not exist.");
            }
        }
        order.setTotalQuantity(order.getProducts().size());
        order.setTotalPrice(order.getTotalPrice());
        entityManager.merge(order);
        entityManager.getTransaction().commit();
        entityManager.close();
    }




}
