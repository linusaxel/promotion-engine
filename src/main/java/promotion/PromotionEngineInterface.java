package promotion;

import java.util.List;
import model.SKU;

public interface PromotionEngineInterface {

  Integer calculateTotalPromotion(List<SKU> skus);

}
