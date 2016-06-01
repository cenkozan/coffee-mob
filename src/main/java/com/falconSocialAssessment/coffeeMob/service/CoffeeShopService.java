package com.falconSocialAssessment.coffeeMob.service;

import com.falconSocialAssessment.coffeeMob.domain.CoffeeShop;
import com.falconSocialAssessment.coffeeMob.request.CoffeeShopRequest;

import java.util.List;

public interface CoffeeShopService {

    void saveCoffeeShopToDb(CoffeeShop coffeeShop);

    CoffeeShop saveCoffeeShopToRedis(CoffeeShopRequest coffeeShopRequest);

    List<CoffeeShop> findAll();
}
