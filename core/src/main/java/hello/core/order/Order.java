package hello.core.order;

public class Order {

  private Long memberId;
  private String itemName;
  private int itemPrice;
  private int discountPrice;

  public Order(
    Long memberId,
    String itemName,
    int itemPrice,
    int discountPrice
  ) {
    this.memberId = memberId;
    this.itemName = itemName;
    this.itemPrice = itemPrice;
    this.discountPrice = discountPrice;
  }

  public Long getMemberId() {
    return memberId;
  }

  public String getItemName() {
    return itemName;
  }

  public int getItemPrice() {
    return itemPrice;
  }

  public int getDiscountPrice() {
    return discountPrice;
  }

  public void setDiscountPrice(int discountPrice) {
    this.discountPrice = discountPrice;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public void setItemPrice(int itemPrice) {
    this.itemPrice = itemPrice;
  }

  public void setMemberId(Long memberId) {
    this.memberId = memberId;
  }

  public int calculatePrice() {
    return itemPrice - discountPrice;
  }

  //객체를 print찍을때 힙 주소가 아닌 해당 메서드가 실행됌.
  @Override
  public String toString() {
    return (
      "Order{" +
      "memberId=" +
      memberId +
      ", itemName='" +
      itemName +
      '\'' +
      ", itemPrice=" +
      itemPrice +
      ", discountPrice=" +
      discountPrice +
      '}'
    );
  }
}
