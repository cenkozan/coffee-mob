package com.falconSocialAssessment.coffeeMob.repository;

import com.falconSocialAssessment.coffeeMob.domain.CoffeeShop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeeShopRepository extends CrudRepository<CoffeeShop, Long> {
}
