package promotion;

public class PromotionTypes {

  public static Integer calculateBulkPromotionForSKUType(int count, int countForPromotion, int promotionValue) {
    if (count == 0) return 0;
    int promotionTimes = count / countForPromotion;
    return promotionTimes * promotionValue;
  }

  public static Integer calculateBundlePromotionForTwoSKUTypes(int count1, int count2, int promotionValue) {
    if (count1 == 0 || count2 == 0) return 0;
    if (count1 >= count2) {
      return promotionValue * count2;
    } else {
      return promotionValue * count1;
    }
  }

}
