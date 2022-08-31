case class Basket(items: List[String] = List()) {
  def add(item: String): Basket = {
    this.copy(items = items :+ item)
  }
}
