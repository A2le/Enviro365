package com.enviro.assessment.grad001.athulentintili.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name="Investors",uniqueConstraints = @UniqueConstraint(columnNames = { "email" }))
public class Investor{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Investor() {
    }

    public Investor(Long id, String name, String address, int age) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Investor id(Long id) {
        setId(id);
        return this;
    }

    public Investor name(String name) {
        setName(name);
        return this;
    }

    public Investor address(String address) {
        setAddress(address);
        return this;
    }

    public Investor age(int age) {
        setAge(age);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Investor)) {
            return false;
        }
        Investor investor = (Investor) o;
        return Objects.equals(id, investor.id) && Objects.equals(name, investor.name) && Objects.equals(address, investor.address) && age == investor.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, age);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", address='" + getAddress() + "'" +
            ", age='" + getAge() + "'" +
            "}";
    }
    private String name;
    private String address;

    public Investor(Long id, String name, String address, String email, int age) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.age = age;
    }
    public Investor(String name, String email, String password,int age) {
        this.password=password;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Investor email(String email) {
        setEmail(email);
        return this;
    }
    private String email;
    private int age;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
        name = "investor_products",
        joinColumns = @JoinColumn(
            name = "investor_id",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(
                name = "product_id",referencedColumnName = "id")
            )
    private List<Product> products;
    private String password;

    public Investor(Long id, String name, String address, String email, int age, List<Product> products, String password) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.age = age;
        this.products = products;
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Investor password(String password) {
        setPassword(password);
        return this;
    }

    public Investor(Long id, String name, String address, String email, int age, List<Product> products) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.age = age;
        this.products = products;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Investor products(List<Product> products) {
        setProducts(products);
        return this;
    }

    


}