import model.Cart;
import model.SKU;
import model.SKUType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import promotion.PromotionEngine;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PromotionEngineTests {

  private Cart cart;
  private PromotionEngine promotionEngine;

  @BeforeEach
  void init() {
    cart = new Cart();
    promotionEngine = new PromotionEngine();
  }

  @Test
  void scenarioA() {
    //Given
    List<SKU> items = cart.getSkus();
    items.add(new SKU(SKUType.A));
    items.add(new SKU(SKUType.B));
    items.add(new SKU(SKUType.C));

    //When
    Integer price = cart.getTotalPriceWithPromotion(promotionEngine);

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
    Integer price = cart.getTotalPriceWithPromotion(promotionEngine);

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
    Integer price = cart.getTotalPriceWithPromotion(promotionEngine);

    //Then
    assertEquals(280, price);
  }

  @Test
  void emptyCartScenario() {
    //When
    Integer price = cart.getTotalPriceWithPromotion(promotionEngine);

    //Then
    assertEquals(0, price);
  }


}
