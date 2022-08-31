import org.scalatest.matchers.must.Matchers
import org.scalatest.freespec.AnyFreeSpec

class MyTest extends AnyFreeSpec with Matchers {
  "Scennario" - {
    "subtask" in {
      1 mustBe 1
    }
  }
}
