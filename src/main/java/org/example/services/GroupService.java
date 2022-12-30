package org.example.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.models.Group;

public class GroupService extends Service {

    public GroupService(EntityManager em, EntityTransaction tx) {
        super(em, tx);
    }

    public Group createGroup(Group group) {
        tx.begin();
        em.persist(group);
        tx.commit();
        return group;
    }
}
