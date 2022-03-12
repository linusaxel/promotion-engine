package promotion;

import java.util.List;
import model.SKU;
import model.SKUType;

public class PromotionEngineImpl implements PromotionEngineInterface {

  @Override
  public Integer calculateTotalPromotion(List<SKU> skus) {
    int promotion = 0;
    promotion += PromotionTypes.calculateBulkPromotion(skus, SKUType.A, 3, 20);
    promotion += PromotionTypes.calculateBulkPromotion(skus, SKUType.B, 2, 15);
    promotion += PromotionTypes.calculatePromotionForTwo(skus, SKUType.C, SKUType.D, 5);
    return promotion;
  }

}
