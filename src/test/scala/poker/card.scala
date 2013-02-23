import org.scalatest.FunSuite
import poker._

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

  test("Strings constructor") {
    val hand = new Hand("As","Kd","5c","8h","4s");
  }

}
