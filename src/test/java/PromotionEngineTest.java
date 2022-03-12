import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PromotionEngineTest {

  private Cart cart;

  @BeforeEach
  void init() {
    cart = new Cart();
  }

  @Test
  void testCase1() {
    //Given
    List<SKU> items = cart.getSkus();
    items.add(new SKU(SKUType.A));
    items.add(new SKU(SKUType.B));
    items.add(new SKU(SKUType.C));

    PromotionEngine engine = new PromotionEngine();

    //When
    Integer price = cart.calculatePrice(engine);

    //Then
    assertEquals(100, price);
  }


}
