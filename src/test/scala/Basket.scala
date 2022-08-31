import scala.annotation.tailrec
case class Basket(items: List[String] = List()) {
  def add(item: String): Basket = {
    this.copy(items = items :+ item)
  }
  def remove(item: String): Basket = {
    this.copy(items = removeLast(item, items))
  }

  @tailrec
  private def removeLast(item: String, items: List[String], processedItems: List[String] = List()): List[String] = {
    if (items == Nil)
      processedItems
    else if (items.last == item)
      processedItems ++ items.init
    else
      removeLast(item, items.init, processedItems :+ items.last)
  }
}
