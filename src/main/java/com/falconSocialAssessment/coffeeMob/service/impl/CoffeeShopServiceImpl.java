package com.falconSocialAssessment.coffeeMob.service.impl;

import com.falconSocialAssessment.coffeeMob.request.CoffeeShopRequest;
import com.falconSocialAssessment.coffeeMob.service.CoffeeShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CoffeeShopServiceImpl implements CoffeeShopService {

    @Autowired
    private RedisTemplate<String, Object> template;

    @Override
    public void saveCoffeeShop(CoffeeShopRequest coffeeShopRequest) {
        final String key = String.format("name:%s", coffeeShopRequest.getCoffeeName());
        final Map<String, Object> properties = new HashMap<>();

        properties.put("name", coffeeShopRequest.getCoffeeName());
        properties.put("date", coffeeShopRequest.getDate().toString());
        properties.put("discount", coffeeShopRequest.getDiscount());
        properties.put("location", coffeeShopRequest.getLocation());
        template.opsForHash().putAll(key, properties);
    }
}
