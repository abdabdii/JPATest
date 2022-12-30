package org.example.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.models.Employee;

public class EmployeeService extends Service {
    public EmployeeService(EntityManager em, EntityTransaction tx) {
        super(em, tx);
    }

    public Employee createEmployee(Employee employee) {
        tx.begin();
        em.persist(employee);
        tx.commit();
        return employee;
    }

    public void removeEmployee(Employee employee) {
        tx.begin();
        em.remove(em.merge(employee));
        tx.commit();
    }

    public Employee findEmployee(Long id) {
        return em.find(Employee.class, id);
    }
}
