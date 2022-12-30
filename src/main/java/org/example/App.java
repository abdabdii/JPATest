package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.models.Address;
import org.example.models.Department;
import org.example.models.Employee;
import org.example.models.Group;
import org.example.services.AddressService;
import org.example.services.DepartmentService;
import org.example.services.EmployeeService;
import org.example.services.GroupService;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("company-persistence-unit");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        // Intialize services
        EmployeeService employeeService = new EmployeeService(em,tx);
        AddressService addressService = new AddressService(em,tx);
        DepartmentService departmentService = new DepartmentService(em,tx);
        GroupService groupService = new GroupService(em,tx);

        // Create a group,department and address
        Department dept = departmentService.createDepartment(new Department("Software development"));


        Address address = addressService.createAddress(new Address("City center street" , "Zagazig" , "Egypt" , 00000));

        Group group = groupService.createGroup(new Group("Workers" , null));

        Set<Group> groupSet = new HashSet<Group>();
        groupSet.add(group);

        // Create Employee
        Employee emp = employeeService.createEmployee(new Employee("Abdalrashid", 4000F,dept,address, groupSet));
        System.out.println(emp);

        // Update Employee
        tx.begin();
        emp.setName("Mohamed");
        em.persist(emp);
        tx.commit();
        System.out.println(emp);

        // Delete Employee
        employeeService.removeEmployee(emp);
        System.out.println("Employee Removed");


    }


}
