import org.scalatest.matchers.must.Matchers
import org.scalatest.freespec.AnyFreeSpec

class DiscountCalculatorSpec extends AnyFreeSpec with Matchers {
  "Shop's discount implementations" - {
    "buy one get one apple free for just one apple" in {
      val basket   = Basket().add("apple")
      val discount = BuyOneGetOneDiscount.calculate(basket)
      discount mustBe 0
    }
    "buy one get one apple free for two apples" in {
      val basket   = Basket().add("apple").add("apple")
      val discount = BuyOneGetOneDiscount.calculate(basket, Map("apple" -> 0.6d))
      discount mustBe 0.6d
    }
  }
}
