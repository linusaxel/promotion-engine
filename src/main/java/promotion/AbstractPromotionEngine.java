package promotion;

import model.SKU;
import model.SKUType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractPromotionEngine {

  protected static Map<SKUType, Integer> countSKUs(List<SKU> skus) {
    Map<SKUType, Integer> skuMap = new HashMap<>();
    for (SKU sku : skus) {
      if (!skuMap.containsKey(sku.getType())) {
        skuMap.put(sku.getType(), 1);
      } else {
        skuMap.put(sku.getType(), skuMap.get(sku.getType()) + 1);
      }
    }
    return skuMap;
  }

  public abstract Integer calculateTotalPromotion(List<SKU> skus);

}
