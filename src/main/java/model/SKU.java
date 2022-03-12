package model;

import lombok.Data;

@Data
public class SKU {

  private SKUType type;
  private Integer price;

  public SKU(SKUType type) {
    this.type = type;
    this.price = type.getValue();
  }

}
