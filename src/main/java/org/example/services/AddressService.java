package org.example.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.models.Address;

public class AddressService extends Service {
    public AddressService(EntityManager em, EntityTransaction tx) {
        super(em, tx);
    }

    public Address createAddress(Address address) {
        tx.begin();
        em.persist(address);
        tx.commit();
        return address;
    }
}
