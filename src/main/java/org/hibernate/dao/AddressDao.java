package org.hibernate.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.model.Address;
import org.hibernate.utils.JpaUtil;

import java.util.function.Consumer;

public class AddressDao {

    public Address getAddressById(EntityManager entityManager, Long id) {
        Address address = entityManager.find(Address.class, id);
        if (address == null) {
            entityManager.close();
            throw new EntityNotFoundException("Address not found");
        }
        return address;
    }

    public void updateAddress(Long addressId, Consumer<Address> updateFunction){
        EntityManager entityManager = JpaUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            Address address = getAddressById(entityManager, addressId);
            updateFunction.accept(address);
            entityManager.merge(address);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw e;
        }finally {
            entityManager.close();
        }
    }

    public void updateStreet(Long addressId, String street) {
        updateAddress(addressId, address -> address.setStreet(street));
    }

    public void updateCity(Long addressId, String city, String street) {
        updateAddress(addressId, address -> address.setCity(city));
        updateAddress(addressId, address -> address.setStreet(street));
    }

    public void updateCity(Long addressId, String city, String state, String street) {
        updateAddress(addressId, address -> address.setCity(city));
        updateAddress(addressId, address -> address.setState(state));
        updateAddress(addressId, address -> address.setStreet(street));
    }

    public void updateCountry(Long addressId, String country, String state, String city, String street) {
        updateAddress(addressId, address -> address.setCountry(country));
        updateAddress(addressId, address -> address.setState(state));
        updateAddress(addressId, address -> address.setCity(city));
        updateAddress(addressId, address -> address.setStreet(street));
    }
}
