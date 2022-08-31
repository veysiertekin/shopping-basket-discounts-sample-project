import scala.annotation.tailrec
case class Basket(items: List[String] = List()) {
  def add(item: String): Basket = {
    this.copy(items = items :+ item)
  }
  def remove(item: String): Basket = {
    this.copy(items = removefirst(item, items))
  }

  @tailrec
  private def removefirst(item: String, items: List[String], processedItems: List[String] = List()): List[String] = {
    items match {
      case Nil                            => processedItems
      case head :: tail if (head == item) => processedItems ++ tail
      case head :: tail                   => removefirst(item, tail, processedItems :+ head)
    }
  }
}
