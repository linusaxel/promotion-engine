package promotion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PromotionTypeLogicTest {

    @Test
    void emptyCartScenario() {
        assertEquals(0, PromotionTypeLogic.calculateBulkPromotionForSKUType(0, 2, 20));
        assertEquals( 20, PromotionTypeLogic.calculateBulkPromotionForSKUType(2, 2, 20));
        assertEquals(40, PromotionTypeLogic.calculateBulkPromotionForSKUType(5, 2, 20));

        assertEquals(0, PromotionTypeLogic.calculateBundlePromotionForTwoSKUTypes(0, 2, 20));
        assertEquals(20, PromotionTypeLogic.calculateBundlePromotionForTwoSKUTypes(5, 1, 20));
        assertEquals(40, PromotionTypeLogic.calculateBundlePromotionForTwoSKUTypes(3, 2, 20));
    }

}