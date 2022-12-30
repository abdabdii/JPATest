package org.example.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class Service {
    protected EntityManager em;
    protected EntityTransaction tx;

    public Service(EntityManager em, EntityTransaction tx) {
        this.em = em;
        this.tx = tx;
    }

}
