package promotion;

public class PromotionTypeLogic {

    public static Integer calculateBulkPromotionForSKUType(int count, int countForPromotion, int promotionValue) {
        if (count == 0) return 0;
        int promotionTimes = count / countForPromotion;
        return promotionTimes * promotionValue;
    }

    public static Integer calculateBundlePromotionForTwoSKUTypes(int countType1, int countType2, int promotionValue) {
        if (countType1 == 0 || countType2 == 0) return 0;
        if (countType1 >= countType2) {
            return promotionValue * countType2;
        } else {
            return promotionValue * countType1;
        }
    }

}
