import org.scalatest.matchers.must.Matchers
import org.scalatest.freespec.AnyFreeSpec

class DiscountCalculatorSpec extends AnyFreeSpec with Matchers {
  "BuyOneGetOneDiscount discount" - {
    "buy one get one apple free for empty basket" in {
      val basket   = Basket()
      val discount = BuyOneGetOneDiscount("apple").calculate(basket, Map("apple" -> 0.6d))
      discount mustBe 0
    }
    "buy one get one apple free for just one apple" in {
      val basket   = Basket().add("apple")
      val discount = BuyOneGetOneDiscount("apple").calculate(basket, Map("apple" -> 0.6d))
      discount mustBe 0
    }
    "buy one get one apple free for two apples in a basket" in {
      val basket   = Basket().add("apple").add("apple")
      val discount = BuyOneGetOneDiscount("apple").calculate(basket, Map("apple" -> 0.6d))
      discount mustBe 0.6d
    }
    "buy one get one apple free for two apples and an orange in a basket" in {
      val basket   = Basket().add("apple").add("apple").add("orange")
      val discount = BuyOneGetOneDiscount("apple").calculate(basket, Map("apple" -> 0.6d))
      discount mustBe 0.6d
    }
    "buy one get one apple free for two apples and two oranges in a basket" in {
      val basket   = Basket().add("apple").add("apple").add("orange").add("orange")
      val discount = BuyOneGetOneDiscount("apple").calculate(basket, Map("apple" -> 0.6d))
      discount mustBe 0.6d
    }
    "buy one get one apple free for three apples" in {
      val basket   = Basket().add("apple").add("apple").add("apple")
      val discount = BuyOneGetOneDiscount("apple").calculate(basket, Map("apple" -> 0.6d))
      discount mustBe 0.6d
    }
    "buy one get one apple free for four apples" in {
      val basket   = Basket().add("apple").add("apple").add("apple").add("apple")
      val discount = BuyOneGetOneDiscount("apple").calculate(basket, Map("apple" -> 0.6d))
      discount mustBe 1.2d
    }
  }
}
