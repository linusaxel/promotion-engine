import java.util.List;

public class PromotionEngineImpl implements PromotionEngineInterface {

  @Override
  public Integer getPromotion(List<SKU> skus) {
    int promotion = 0;
    promotion += calculateBulkPromotion(skus, SKUType.A, 3, 20);
    promotion += calculateBulkPromotion(skus, SKUType.B, 2, 15);
    promotion += calculatePromotionForTwo(skus, SKUType.C, SKUType.D, 5);
    return promotion;
  }

  private Integer calculateBulkPromotion(List<SKU> skus, SKUType type, int numOfSKUForPromotion, int promotionValue) {
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

  private Integer calculatePromotionForTwo(List<SKU> skus, SKUType type1, SKUType type2, int promotionValue) {
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
