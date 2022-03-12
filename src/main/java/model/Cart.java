package model;

import java.util.LinkedList;
import java.util.List;
import lombok.Getter;
import promotion.PromotionEngineInterface;

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

  public Integer getTotalPriceWithPromotion(PromotionEngineInterface engine) {
    return getTotalPrice() - engine.calculateTotalPromotion(skus);
  }
}
