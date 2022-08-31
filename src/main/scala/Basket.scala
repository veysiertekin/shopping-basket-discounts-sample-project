import scala.annotation.tailrec

case class Basket(items: List[String] = List()) {
  def add(item: String): Basket = {
    this.copy(items = items :+ item)
  }
  def remove(item: String): Basket = {
    this.copy(items = removeLastMatch(item, items))
  }

  @tailrec
  private def removeLastMatch(
    item: String,
    items: List[String],
    processedItems: List[String] = List()
  ): List[String] = {
    items match {
      case Nil                         => processedItems
      case list if (list.last == item) => list.init ++ processedItems
      case list                        => removeLastMatch(item, list.init, list.last +: processedItems)
    }
  }
}
