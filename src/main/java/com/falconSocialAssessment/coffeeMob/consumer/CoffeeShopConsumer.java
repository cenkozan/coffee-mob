package com.falconSocialAssessment.coffeeMob.consumer;

import com.falconSocialAssessment.coffeeMob.domain.CoffeeShop;
import com.falconSocialAssessment.coffeeMob.service.CoffeeShopService;
import com.google.gson.Gson;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

public class CoffeeShopConsumer implements MessageListener {

    CoffeeShopService coffeeShopService;

    public CoffeeShopConsumer(CoffeeShopService coffeeShopService) {
        this.coffeeShopService = coffeeShopService;
    }

    @Override
    public void onMessage(Message message, final byte[] pattern ) {
        System.out.println( "Message received: " + message.toString() );
        Gson gson = new Gson();
        CoffeeShop coffeeShop = gson.fromJson(message.toString(), CoffeeShop.class);
        coffeeShopService.saveCoffeeShopToDb(coffeeShop);
    }
}
