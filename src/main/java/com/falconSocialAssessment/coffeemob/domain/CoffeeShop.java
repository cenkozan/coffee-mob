package com.falconSocialAssessment.coffeeMob.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class CoffeeShop {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String coffeeShopName;
    private Date date;
    private String discount;
    private String location;

    protected CoffeeShop() {
    }

    public CoffeeShop(String coffeeShopName, Date date, String discount, String location) {
        this.coffeeShopName = coffeeShopName;
        this.date = date;
        this.discount = discount;
        this.location = location;
    }

    public String getCoffeeShopName() {
        return coffeeShopName;
    }

    public void setCoffeeShopName(String coffeeShopName) {
        this.coffeeShopName = coffeeShopName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return String.format(
                "CoffeeShop[id=%d, coffeeShopName='%s', date='%s', discount='%s, location='%s]",
                id, coffeeShopName, date, discount, location);
    }
}
