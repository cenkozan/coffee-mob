package com.falconSocialAssessment.coffeeMob.service.impl;

import com.falconSocialAssessment.coffeeMob.domain.CoffeeShop;
import com.falconSocialAssessment.coffeeMob.repository.CoffeeShopRepository;
import com.falconSocialAssessment.coffeeMob.request.CoffeeShopRequest;
import com.falconSocialAssessment.coffeeMob.service.CoffeeShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CoffeeShopServiceImpl implements CoffeeShopService {

    @Autowired
    RedisTemplate<String, Object> template;

    @Autowired
    CoffeeShopRepository coffeeShopRepository;

    @Override
    public void saveCoffeeShopToDb(CoffeeShop coffeeShop) {
        coffeeShopRepository.save(coffeeShop);
    }

    @Override
    public CoffeeShop saveCoffeeShopToRedis(CoffeeShopRequest coffeeShopRequest) {
        final String key = String.format("name:%s", coffeeShopRequest.getCoffeeName());
        final Map<String, Object> properties = new HashMap<>();
        properties.put("name", coffeeShopRequest.getCoffeeName());
        properties.put("date", coffeeShopRequest.getDate());
        properties.put("discount", coffeeShopRequest.getDiscount());
        properties.put("location", coffeeShopRequest.getLocation());
        template.opsForHash().putAll(key, properties);
        return coffeeShopRequest.toCoffeeShop();
    }

    @Override
    public List<CoffeeShop> findAll() {
        return (List<CoffeeShop>) coffeeShopRepository.findAll();
    }

}
