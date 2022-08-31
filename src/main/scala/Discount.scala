sealed trait Discount {
  def calculate(basket: Basket): Double
}
case object BuyOneGetOneDiscount extends Discount {
  override def calculate(basket: Basket): Double = {
    0d
  }
}
