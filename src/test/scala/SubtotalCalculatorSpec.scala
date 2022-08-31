import org.scalatest.matchers.must.Matchers
import org.scalatest.freespec.AnyFreeSpec

class SubtotalCalculatorSpec extends AnyFreeSpec with Matchers {
  "Subtotal calculation tests" - {
    "calculate sub total for an empty basket" in {
      val basket     = Basket()
      val calculator = SubtotalCalculator(basket)
      calculator.total mustBe 0d
    }
  }
}
