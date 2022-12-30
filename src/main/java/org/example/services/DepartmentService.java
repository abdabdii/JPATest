package org.example.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.models.Department;

public class DepartmentService extends Service {
    public DepartmentService(EntityManager em, EntityTransaction tx) {
        super(em, tx);
    }

    public Department createDepartment(Department department) {
        tx.begin();
        em.persist(department);
        tx.commit();
        return department;
    }
}
