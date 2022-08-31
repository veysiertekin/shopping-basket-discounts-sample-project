sealed trait Discount {
  def calculate(basket: Basket, basePrices: Map[String, Double] = Map()): Double
}
case class ThreeForTwoDiscount(itemName: String) extends Discount {
  override def calculate(basket: Basket, basePrices: Map[String, Double]): Double = {
    val filteredItems = basket.items.filter(_ == itemName)
    if (filteredItems.isEmpty) {
      0
    } else {
      val numberOfElements  = filteredItems.size
      val discountOccurance = numberOfElements / 3
      basePrices(itemName) * discountOccurance
    }
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
      basePrices(itemName) * discountOccurance
    }
  }
}
