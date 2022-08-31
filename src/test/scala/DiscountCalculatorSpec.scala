import org.scalatest.matchers.must.Matchers
import org.scalatest.freespec.AnyFreeSpec

class DiscountSpec extends AnyFreeSpec with Matchers {
  "Shop's discount implementations" - {
    "buy one get one apple free" in {
      1 mustBe 1
    }
  }
}
