package service;

import model.SKU;
import model.SKUType;
import org.junit.jupiter.api.Test;
import promotion.PromotionEngineImpl;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CheckoutServiceTests {

    private CheckoutService checkoutService;

    @Test
    void scenarioA() {
        //Given
        List<SKU> items = new LinkedList<>();
        items.add(new SKU(SKUType.A));
        items.add(new SKU(SKUType.B));
        items.add(new SKU(SKUType.C));

        //When
        checkoutService = new CheckoutService(items, new PromotionEngineImpl());

        Integer checkoutPrice = checkoutService.checkout();
        Integer totalPromotionPrice = checkoutService.getTotalPromotionPrice();
        Integer totalPrice = checkoutService.getTotalPrice();

        //Then
        assertEquals(100, checkoutPrice);
        assertEquals(0, totalPromotionPrice);
        assertEquals(100, totalPrice);
    }

    @Test
    void scenarioB() {
        //Given
        List<SKU> items = new LinkedList<>();
        items.add(new SKU(SKUType.A));
        items.add(new SKU(SKUType.A));
        items.add(new SKU(SKUType.A));
        items.add(new SKU(SKUType.A));
        items.add(new SKU(SKUType.A));
        items.add(new SKU(SKUType.B));
        items.add(new SKU(SKUType.B));
        items.add(new SKU(SKUType.B));
        items.add(new SKU(SKUType.B));
        items.add(new SKU(SKUType.B));
        items.add(new SKU(SKUType.C));

        //When
        checkoutService = new CheckoutService(items, new PromotionEngineImpl());
        Integer checkoutPrice = checkoutService.checkout();
        Integer totalPromotionPrice = checkoutService.getTotalPromotionPrice();
        Integer totalPrice = checkoutService.getTotalPrice();

        //Then
        assertEquals(370, checkoutPrice);
        assertEquals(50, totalPromotionPrice);
        assertEquals(420, totalPrice);
    }

    @Test
    void scenarioC() {
        //Given
        List<SKU> items = new LinkedList<>();
        items.add(new SKU(SKUType.A));
        items.add(new SKU(SKUType.A));
        items.add(new SKU(SKUType.A));
        items.add(new SKU(SKUType.B));
        items.add(new SKU(SKUType.B));
        items.add(new SKU(SKUType.B));
        items.add(new SKU(SKUType.B));
        items.add(new SKU(SKUType.B));
        items.add(new SKU(SKUType.C));
        items.add(new SKU(SKUType.D));

        //When
        checkoutService = new CheckoutService(items, new PromotionEngineImpl());
        Integer checkoutPrice = checkoutService.checkout();
        Integer totalPromotionPrice = checkoutService.getTotalPromotionPrice();
        Integer totalPrice = checkoutService.getTotalPrice();

        //Then
        assertEquals(280, checkoutPrice);
        assertEquals(55, totalPromotionPrice);
        assertEquals(335, totalPrice);
    }

    @Test
    void emptyCartScenario() {
        List<SKU> items = new LinkedList<>();

        assertThrows(IllegalArgumentException.class, () -> {
            checkoutService = new CheckoutService(items, new PromotionEngineImpl());
        });
    }

    @Test
    void emptyEngineScenario() {
        List<SKU> items = new LinkedList<>();
        items.add(new SKU(SKUType.A));

        assertThrows(IllegalArgumentException.class, () -> {
            checkoutService = new CheckoutService(items, null);
        });
    }

}
