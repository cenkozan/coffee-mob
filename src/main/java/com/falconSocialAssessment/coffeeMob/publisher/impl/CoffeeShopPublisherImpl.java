package com.falconSocialAssessment.coffeeMob.publisher.impl;

import com.falconSocialAssessment.coffeeMob.domain.CoffeeShop;
import com.falconSocialAssessment.coffeeMob.publisher.CoffeeShopPublisher;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;

public class CoffeeShopPublisherImpl implements CoffeeShopPublisher{
    private final RedisTemplate<String, Object> template;
    private final ChannelTopic topic;

    public CoffeeShopPublisherImpl(final RedisTemplate<String, Object> template, final ChannelTopic topic) {
        this.template = template;
        this.topic = topic;
    }

    @Override
    public void publish(CoffeeShop coffeeShop) {
        template.convertAndSend(topic.getTopic(), coffeeShop);
    }

}
