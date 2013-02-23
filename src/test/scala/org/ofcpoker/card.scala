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

class HandSuite extends FunSuite {
  test("New Hand") {
    val hand = new Hand(
      List(
        new Card("2s"),
        new Card("3s"),
        new Card("4s"),
        new Card("5s"),
        new Card("6s"))
      );
  }

  test("Invalid hand: too few cards") {
    try {
      val hand = new Hand(
        List(
          new Card("2s"),
          new Card("3s"),
          new Card("4s"),
          new Card("5s")
        ))

      fail()
    }
    catch {
      case _: IllegalArgumentException =>
    }
  }

  test("String constructor") {
    val hand = new Hand("As Kd 5c 8h 4s");
  }

  test("hand.toString") {
    assert(new Hand("As Kd 5c 8h 4s").toString == "As Kd 5c 8h 4s");
  }

  test("hand.sorted") {
    val hand = new Hand("Kd As 5c 8h 4s");
    assert(hand.sortedCards.mkString(" ") == "As Kd 8h 5c 4s");
  }


}
