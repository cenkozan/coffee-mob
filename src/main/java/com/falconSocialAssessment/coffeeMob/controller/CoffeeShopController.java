package com.falconSocialAssessment.coffeeMob.controller;

import com.falconSocialAssessment.coffeeMob.domain.CoffeeShop;
import com.falconSocialAssessment.coffeeMob.publisher.CoffeeShopPublisher;
import com.falconSocialAssessment.coffeeMob.request.CoffeeShopRequest;
import com.falconSocialAssessment.coffeeMob.service.CoffeeShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/coffee-shop-service")
public class CoffeeShopController {

    @Autowired
    private SimpMessagingTemplate template;

    CoffeeShopService coffeeShopService;
    CoffeeShopPublisher coffeeShopPublisher;

    private final String topic = "/topic/coffee-shops";

    @Autowired
    public CoffeeShopController(CoffeeShopService coffeeShopService, CoffeeShopPublisher coffeeShopPublisher) {
        this.coffeeShopService = coffeeShopService;
        this.coffeeShopPublisher = coffeeShopPublisher;
    }

    @RequestMapping(value = "/coffee-shop", method = RequestMethod.PUT)
    public @ResponseBody String saveCoffeeShop(@RequestBody @Valid CoffeeShopRequest coffeeShopRequest) {
        CoffeeShop coffeeShop = coffeeShopRequest.toCoffeeShop();
        coffeeShopService.saveCoffeeShopToRedis(coffeeShopRequest);
        coffeeShopPublisher.publish(coffeeShop);
        template.convertAndSend(topic, coffeeShop);
        return "Coffee shop successfully created.";
    }

    @MessageMapping("/coffee-shops")
    @SendTo(topic)
    public @ResponseBody List<CoffeeShop> getAllCoffeeShops() throws Exception{
        Thread.sleep(3000);
        return coffeeShopService.findAll();
    }
}
