import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PromotionEngineTests {

  private Cart cart;
  PromotionEngineImpl promotionEngine;

  @BeforeEach
  void init() {
    cart = new Cart();
    promotionEngine = new PromotionEngineImpl();
  }

  @Test
  void scenarioA() {
    //Given
    List<SKU> items = cart.getSkus();
    items.add(new SKU(SKUType.A));
    items.add(new SKU(SKUType.B));
    items.add(new SKU(SKUType.C));

    //When
    Integer price = cart.calculatePriceWithPromotion(promotionEngine);

    //Then
    assertEquals(100, price);
  }

  @Test
  void scenarioB() {
    //Given
    List<SKU> items = cart.getSkus();
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
    Integer price = cart.calculatePriceWithPromotion(promotionEngine);

    //Then
    assertEquals(370, price);
  }

  @Test
  void scenarioC() {
    //Given
    List<SKU> items = cart.getSkus();
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
    Integer price = cart.calculatePriceWithPromotion(promotionEngine);

    //Then
    assertEquals(280, price);
  }


}
