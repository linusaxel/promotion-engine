package service;

import model.SKU;
import promotion.PromotionEngine;

import java.util.List;

public class CheckoutService {

    private final List<SKU> skuCart;
    private final PromotionEngine engine;

    public CheckoutService(List<SKU> skuCart, PromotionEngine engine) {
        if (skuCart == null || skuCart.size() == 0)
            throw new IllegalArgumentException("Cannot initialize a CheckoutService without a cart");
        if (engine == null)
            throw new IllegalArgumentException("Cannot initialize a CheckoutService without a promotion engine");
        this.skuCart = skuCart;
        this.engine = engine;
    }

    public Integer getTotalPrice() {
        Integer totalPrice = 0;
        for (SKU sku : skuCart) {
            totalPrice += sku.getPrice();
        }
        return totalPrice;
    }

    public Integer getTotalPromotionPrice() {
        return engine.calculateTotalPromotion(skuCart);
    }

    public Integer checkout() {
        return getTotalPrice() - getTotalPromotionPrice();
    }
}
