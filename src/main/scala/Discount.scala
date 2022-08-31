sealed abstract class Discount(itemName: String) {
  def calculate(basket: Basket, basePrices: Map[String, Double] = Map()): Double

  protected def calculateByOccurance(
    basket: Basket,
    basePrices: Map[String, Double],
    occurance: Int
  ): Double = {
    val filteredItems = basket.items.filter(_ == itemName)
    if (filteredItems.isEmpty) {
      0d
    } else {
      val numberOfElements  = filteredItems.size
      val discountOccurance = numberOfElements / occurance
      basePrices(itemName) * discountOccurance
    }
  }
}
case class ThreeForTwoDiscount(itemName: String) extends Discount(itemName) {
  override def calculate(basket: Basket, basePrices: Map[String, Double]): Double = {
    calculateByOccurance(basket, basePrices, 3)
  }
}
case class BuyOneGetOneDiscount(itemName: String) extends Discount(itemName) {
  override def calculate(basket: Basket, basePrices: Map[String, Double] = Map()): Double = {
    calculateByOccurance(basket, basePrices, 2)
  }
}
