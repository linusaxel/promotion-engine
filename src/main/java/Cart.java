import java.util.LinkedList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cart {

  private List<SKU> skus = new LinkedList<>();

  public Integer calculatePrice(PromotionEngine engine) {
    Integer totalPrice = 0;
    for (SKU sku : skus) {
      totalPrice += sku.getPrice();
    }
    return totalPrice;
  }
}
