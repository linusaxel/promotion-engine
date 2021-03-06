package promotion;

import model.SKU;
import model.SKUType;

import java.util.List;
import java.util.Map;

public class PromotionEngineImpl extends PromotionEngine {

    @Override
    public Integer calculateTotalPromotion(List<SKU> skus) {
        int promotion = 0;
        Map<SKUType, Integer> countMap = countSKUs(skus);
        promotion += PromotionTypeLogic.calculateBulkPromotionForSKUType(countMap.getOrDefault(SKUType.A, 0), 3, 20);
        promotion += PromotionTypeLogic.calculateBulkPromotionForSKUType(countMap.getOrDefault(SKUType.B, 0), 2, 15);
        promotion += PromotionTypeLogic.calculateBundlePromotionForTwoSKUTypes(countMap.getOrDefault(SKUType.C, 0), countMap.getOrDefault(SKUType.D, 0), 5);
        return promotion;
    }

}
