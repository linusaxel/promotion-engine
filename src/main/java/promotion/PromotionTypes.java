package promotion;

import java.util.List;
import model.SKU;
import model.SKUType;

public class PromotionTypes {

  public static Integer calculateBulkPromotion(List<SKU> skus, SKUType type, int numOfSKUForPromotion, int promotionValue) {
    int numOfType = 0;
    for (SKU sku : skus) {
      if (sku.getType().equals(type)) {
        numOfType += 1;
      }
    }
    if (numOfType == 0) return 0;
    int promotionTimes = numOfType / numOfSKUForPromotion;
    return promotionTimes * promotionValue;
  }

  public static Integer calculatePromotionForTwo(List<SKU> skus, SKUType type1, SKUType type2, int promotionValue) {
    int numOfType1 = 0;
    int numOfType2 = 0;
    for (SKU sku : skus) {
      if (sku.getType().equals(type1)) {
        numOfType1 += 1;
      }
      if (sku.getType().equals(type2)) {
        numOfType2 += 1;
      }
    }
    if (numOfType1 == 0 || numOfType2 == 0) return 0;
    if (numOfType1 >= numOfType2) {
      return promotionValue * numOfType2;
    } else {
      return promotionValue * numOfType1;
    }
  }

}
