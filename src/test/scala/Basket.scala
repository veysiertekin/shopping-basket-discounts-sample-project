case class Basket(items: List[String] = List()) {
  def add(item: String): Basket = {
    this.copy(items = items :+ item)
  }
  def remove(item: String): Basket = {
    items match {
      case Nil    => this.copy(items = List())
      case others => this.copy(items = others.tail)
    }
  }
}
