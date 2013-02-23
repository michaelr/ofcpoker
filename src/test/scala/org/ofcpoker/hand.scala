import org.scalatest.FunSuite
import org.ofcpoker._

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

  test("flush") {
    val hand = new Hand("Ks As 5s 8s 4s");
    assert(hand.rank == "Flush")
  }

}
