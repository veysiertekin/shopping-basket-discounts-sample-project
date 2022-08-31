import org.scalatest.matchers.must.Matchers
import org.scalatest.freespec.AnyFreeSpec

class DiscountCalculatorSpec extends AnyFreeSpec with Matchers {
  "Shop's discount implementations" - {
    "buy one get one apple free for just one apple" in {
      val basket   = Basket().add("apple")
      val discount = BuyOneGetOneDiscount.calculate(basket)
      discount mustBe 0
    }
  }
}
