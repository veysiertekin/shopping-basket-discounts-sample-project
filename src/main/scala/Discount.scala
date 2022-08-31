sealed trait Discount {
  def calculate(basket: Basket, basePrices: Map[String, Double] = Map()): Double
}
case object BuyOneGetOneDiscount extends Discount {
  override def calculate(basket: Basket, basePrices: Map[String, Double] = Map()): Double = {
    val numberOfElements  = basket.items.size
    val discountOccurance = numberOfElements / 2
    basePrices(basket.items.head) * discountOccurance
  }
}
