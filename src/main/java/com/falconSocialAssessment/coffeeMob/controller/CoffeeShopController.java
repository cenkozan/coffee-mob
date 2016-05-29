package com.falconSocialAssessment.coffeeMob.controller;

import com.falconSocialAssessment.coffeeMob.request.CoffeeShopRequest;
import com.falconSocialAssessment.coffeeMob.service.CoffeeShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coffeeshopservice")
public class CoffeeShopController {

    CoffeeShopService coffeeShopService;

    @Autowired
    public CoffeeShopController(CoffeeShopService coffeeShopService) {
        this.coffeeShopService = coffeeShopService;
    }

    @RequestMapping(value = "/coffee-shop", method = RequestMethod.PUT)
    public @ResponseBody String saveCoffeeShop(@RequestBody CoffeeShopRequest coffeeShopRequest) {
        coffeeShopService.saveCoffeeShop(coffeeShopRequest);
        return "Coffee Shop successfully created";
    }

}
