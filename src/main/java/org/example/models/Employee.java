package org.example.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Employee {

    public Employee( String name, Float salary, Department department, Address address, Set<Group> groupSet) {
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.address = address;
        this.groupSet = groupSet;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Float salary;

    @ManyToOne
    private Department department;

    @ManyToOne
    private Address address;

    public Employee() {
    }

    @ManyToMany
    private Set<Group> groupSet;

    public Set<Group> getGroupSet() {
        return groupSet;
    }

    public void setGroupSet(Set<Group> groupSet) {
        this.groupSet = groupSet;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", department=" + department +
                '}';
    }
}
