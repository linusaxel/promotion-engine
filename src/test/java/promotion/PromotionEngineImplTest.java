package promotion;

import model.SKU;
import model.SKUType;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PromotionEngineImplTest {

    @Test
    void countSKUsTest() {
        //Given
        List<SKU> skus = new LinkedList<>();
        skus.add(new SKU(SKUType.A));
        skus.add(new SKU(SKUType.A));
        skus.add(new SKU(SKUType.B));
        skus.add(new SKU(SKUType.B));
        skus.add(new SKU(SKUType.B));
        skus.add(new SKU(SKUType.C));
        skus.add(new SKU(SKUType.D));
        skus.add(new SKU(SKUType.D));

        //When
        Map<SKUType, Integer> countMap = PromotionEngine.countSKUs(skus);

        //Then
        assertEquals(2, countMap.get(SKUType.A));
        assertEquals(3, countMap.get(SKUType.B));
        assertEquals(1, countMap.get(SKUType.C));
        assertEquals(2, countMap.get(SKUType.D));
    }

}