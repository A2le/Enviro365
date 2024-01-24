package com.enviro.assessment.grad001.athulentintili.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name="Producs")
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String product_name;
    private String product_type;
    private double Product_current_balance;

    public Product() {
    }

    public Product(Long product_id, String product_name, String product_type, double Product_current_balance) {
        this.id = product_id;
        this.product_name = product_name;
        this.product_type = product_type;
        this.Product_current_balance = Product_current_balance;
    }

    public Long getProduct_id() {
        return this.id;
    }

    public void setProduct_id(Long product_id) {
        this.id = product_id;
    }

    public String getProduct_name() {
        return this.product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_type() {
        return this.product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public double getProduct_current_balance() {
        return this.Product_current_balance;
    }

    public void setProduct_current_balance(double Product_current_balance) {
        this.Product_current_balance = Product_current_balance;
    }

    public Product product_id(Long product_id) {
        setProduct_id(product_id);
        return this;
    }

    public Product product_name(String product_name) {
        setProduct_name(product_name);
        return this;
    }

    public Product product_type(String product_type) {
        setProduct_type(product_type);
        return this;
    }

    public Product Product_current_balance(double Product_current_balance) {
        setProduct_current_balance(Product_current_balance);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Product)) {
            return false;
        }
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(product_name, product.product_name) && Objects.equals(product_type, product.product_type) && Product_current_balance == product.Product_current_balance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product_name, product_type, Product_current_balance);
    }

    @Override
    public String toString() {
        return "{" +
            " product_id='" + getProduct_id() + "'" +
            ", product_name='" + getProduct_name() + "'" +
            ", product_type='" + getProduct_type() + "'" +
            ", Product_current_balance='" + getProduct_current_balance() + "'" +
            "}";
    }

}
