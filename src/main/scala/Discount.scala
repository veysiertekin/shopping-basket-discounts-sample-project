sealed trait Discount {
  def calculate(basket: Basket, basePrices: Map[String, Double] = Map()): Double
}
case object ThreeForTwoDiscount extends Discount {
  override def calculate(basket: Basket, basePrices: Map[String, Double]): Double = {
    0
  }
}
case class BuyOneGetOneDiscount(itemName: String) extends Discount {
  override def calculate(basket: Basket, basePrices: Map[String, Double] = Map()): Double = {
    val filteredItems = basket.items.filter(_ == itemName)
    if (filteredItems.isEmpty) {
      0d
    } else {
      val numberOfElements  = filteredItems.size
      val discountOccurance = numberOfElements / 2
      basePrices(filteredItems.head) * discountOccurance
    }
  }
}
