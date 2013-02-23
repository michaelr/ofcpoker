import org.scalatest.FunSuite
import org.ofcpoker._

class CardSuite extends FunSuite {
  test("New card") {
    val card = new Card( '2', 'h')
    assert(card.rank === '2')
  }

  test("Invalid rank") {
    try {
      val card = new Card( '1', 'h')
      fail()
    }
    catch {
      case _: IllegalArgumentException =>
    }
  }

  test("Invalid suit") {
    try {
      val card = new Card( '2', 'a')
      fail()
    }
    catch {
      case _: IllegalArgumentException =>
    }
  }

  test("toString") {
    assert(new Card( 'a', 's').toString === "As")
    assert(new Card( 'k', 'h').toString === "Kh")
    assert(new Card( '3', 'D').toString === "3d")
  }

  test("new Card(String)") {
    assert(new Card("Ah").toString === "Ah");
  }

  test("cart.rankInt") {
    assert(new Card("2d").rankInt == 2);
  }

}


