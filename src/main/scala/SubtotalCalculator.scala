case class SubtotalCalculator(
  basket: Basket,
  basePrices: Map[String, BigDecimal] = Map(),
  discounts: List[Discount] = List()
) {
  def total: BigDecimal = {
    val totalDiscount = discounts.map(_.calculate(basket, basePrices)).sum
    val subtotal = basket.items.foldRight(BigDecimal(0))({
      case (element, total) => basePrices(element) + total
    })
    subtotal - totalDiscount
  }
}
