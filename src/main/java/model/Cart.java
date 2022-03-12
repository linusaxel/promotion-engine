package model;

import lombok.Getter;
import promotion.AbstractPromotionEngine;

import java.util.LinkedList;
import java.util.List;

@Getter
public class Cart {

  private final List<SKU> skus = new LinkedList<>();

  public Integer getTotalPrice() {
    Integer totalPrice = 0;
    for (SKU sku : skus) {
      totalPrice += sku.getPrice();
    }
    return totalPrice;
  }

  public Integer getTotalPriceWithPromotion(AbstractPromotionEngine engine) {
    return getTotalPrice() - engine.calculateTotalPromotion(skus);
  }
}
