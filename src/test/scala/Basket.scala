case class Basket(items: List[String] = List()) {
  def add(item: String): Basket = {
    this.copy(items = items :+ item)
  }
  def remove(item: String): Basket = {
    def removefirst(item: String, items: List[String]): List[String] = {
      items match {
        case Nil                            => List()
        case head :: tail if (head == item) => tail
        case head :: tail                   => head :: removefirst(item, tail)
      }
    }

    this.copy(items = removefirst(item, items))
  }
}
