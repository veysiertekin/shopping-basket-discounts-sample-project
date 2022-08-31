import org.scalatest.matchers.must.Matchers
import org.scalatest.freespec.AnyFreeSpec

class BasketSpec extends AnyFreeSpec with Matchers {
  "Adding/removing items tests" - {
    "add an apple to empty basket" in {
      val basket = Basket().add("apple")
      basket.items mustBe List("apple")
    }
    "add two apples to empty basket" in {
      val basket = Basket().add("apple").add("apple")
      basket.items mustBe List("apple", "apple")
    }
    "remove non-existent item from empty basket" in {
      val basket = Basket().remove("non-existent")
      basket.items mustBe List()
    }
    "add an apple and remove non-existent item from basket" in {
      val basket = Basket().add("apple").remove("non-existent")
      basket.items mustBe List("apple")
    }
  }
}
