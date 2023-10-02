package com.js.productservice.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity(name = "price")
//@Getter
//@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Price extends BaseModel {
    String currency;
    double price;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
