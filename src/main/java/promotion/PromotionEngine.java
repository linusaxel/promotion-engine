package promotion;

import model.SKU;
import model.SKUType;

import java.util.List;
import java.util.Map;

public class PromotionEngine extends AbstractPromotionEngine {

    @Override
    public Integer calculateTotalPromotion(List<SKU> skus) {
        int promotion = 0;
        Map<SKUType, Integer> countMap = countSKUs(skus);
        promotion += PromotionTypes.calculateBulkPromotionForSKUType(countMap.getOrDefault(SKUType.A, 0), 3, 20);
        promotion += PromotionTypes.calculateBulkPromotionForSKUType(countMap.getOrDefault(SKUType.B, 0), 2, 15);
        promotion += PromotionTypes.calculateBundlePromotionForTwoSKUTypes(countMap.getOrDefault(SKUType.C, 0), countMap.getOrDefault(SKUType.D, 0), 5);
        return promotion;
    }

}
