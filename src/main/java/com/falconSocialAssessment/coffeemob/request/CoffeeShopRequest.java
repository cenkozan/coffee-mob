package com.falconSocialAssessment.coffeeMob.request;

import com.falconSocialAssessment.coffeeMob.domain.CoffeeShop;

public class CoffeeShopRequest {

    private String coffeeName;
    private String date;
    private String discount;
    private String location;

    public String getCoffeeName() {
        return coffeeName;
    }

    public void setCoffeeName(String coffeeName) {
        this.coffeeName = coffeeName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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

    public CoffeeShop toCoffeeShop() {
        CoffeeShop coffeeShop = new CoffeeShop(this.coffeeName, this.date, this.discount, this.location);
        return coffeeShop;
    }
}
