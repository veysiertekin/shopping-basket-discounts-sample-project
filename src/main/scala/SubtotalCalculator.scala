case class SubtotalCalculator(basket: Basket, basePrices: Map[String, Double] = Map()) {
  def total: Double = {
    basket.items.foldRight(0d)({
      case (element, total) => basePrices(element) + total
    })
  }
}
