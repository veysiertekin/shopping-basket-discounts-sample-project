sealed abstract class Discount(itemName: String) {
  def calculate(basket: Basket, basePrices: Map[String, BigDecimal] = Map()): BigDecimal

  protected def calculateByOccurance(
    basket: Basket,
    basePrices: Map[String, BigDecimal],
    occurance: Int
  ): BigDecimal = {
    val filteredItems = basket.items.filter(_ == itemName)
    if (filteredItems.isEmpty) {
      BigDecimal(0)
    } else {
      val numberOfElements  = filteredItems.size
      val discountOccurance = numberOfElements / occurance
      basePrices(itemName) * discountOccurance
    }
  }
}
case class ThreeForTwoDiscount(itemName: String) extends Discount(itemName) {
  override def calculate(basket: Basket, basePrices: Map[String, BigDecimal]): BigDecimal = {
    calculateByOccurance(basket, basePrices, 3)
  }
}
case class BuyOneGetOneDiscount(itemName: String) extends Discount(itemName) {
  override def calculate(basket: Basket, basePrices: Map[String, BigDecimal] = Map()): BigDecimal = {
    calculateByOccurance(basket, basePrices, 2)
  }
}
