sealed trait Discount {
  def calculate(basket: Basket, basePrices: Map[String, Double] = Map()): Double
}
case object ThreeForTwoDiscount extends Discount {
  override def calculate(basket: Basket, basePrices: Map[String, Double]): Double = {
    val numberOfElements  = basket.items.size
    val discountOccurance = numberOfElements / 3
    basePrices(basket.items.head) * discountOccurance
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
