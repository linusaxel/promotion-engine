package model;

import lombok.Getter;

@Getter
public enum SKUType {
  A(50),
  B(30),
  C(20),
  D(15);

  private final Integer value;

  SKUType(final Integer value) {
    this.value = value;
  }

}
