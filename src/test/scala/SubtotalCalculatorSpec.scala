import org.scalatest.matchers.must.Matchers
import org.scalatest.freespec.AnyFreeSpec

class SubtotalCalculatorSpec extends AnyFreeSpec with Matchers {
  "Subtotal calculation tests" - {
    "calculate sub total for an empty basket" in {
      val basket     = Basket()
      val calculator = SubtotalCalculator(basket)
      calculator.total mustBe 0d
    }
    "calculate sub total for basket contains an apple" in {
      val basket     = Basket().add("apple")
      val calculator = SubtotalCalculator(basket, Map("apple" -> 0.6d))
      calculator.total mustBe 0.6d
    }
    "calculate sub total for basket contains an orange" in {
      val basket     = Basket().add("orange")
      val calculator = SubtotalCalculator(basket, Map("orange" -> 0.25d))
      calculator.total mustBe 0.25d
    }
    "calculate sub total for basket contains 3 apples and an orange" in {
      val basket     = Basket().add("apple").add("apple").add("orange").add("apple")
      val calculator = SubtotalCalculator(basket, Map("orange" -> 0.25d, "apple" -> 0.6d))
      calculator.total mustBe 2.05d
    }
    "subtotal with discounted apples in basket contains 3 apples & an orange" in {
      val basket = Basket().add("apple").add("apple").add("orange").add("apple")
      val calculator =
        SubtotalCalculator(basket, Map("orange" -> 0.25d, "apple" -> 0.6d), List(BuyOneGetOneDiscount("apple")))
      calculator.total mustBe 1.45d
    }
  }
}
