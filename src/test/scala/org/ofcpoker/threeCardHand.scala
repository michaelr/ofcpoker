import org.scalatest.FunSuite
import org.ofcpoker._

class ThreeCardHandSuite extends FunSuite {
  test("New Hand") {
    val hand = new ThreeCardHand(
      List(
        new Card("2s"),
        new Card("3s"),
        new Card("4s")
      ))
  }

  test("Invalid hand: too many cards") {
    try {
      val hand = new ThreeCardHand(
        List(
          new Card("2s"),
          new Card("3s"),
          new Card("4s"),
          new Card("5s"),
          new Card("6s")
        ))

      fail()
    }
    catch {
      case _: IllegalArgumentException =>
    }
  }

  test("String constructor") {
    val hand = new ThreeCardHand("As Kd 4s");
  }

  test("hand.toString") {
    assert(new ThreeCardHand("As Kd 5c").toString == "As Kd 5c");
  }

  test("hand.sorted") {
    val hand = new ThreeCardHand("Kd As 5c");
    assert(hand.sortedCards.mkString(" ") == "As Kd 5c");
  }

  test("Three of a Kind") {
    val hand = new ThreeCardHand("2d 2s 2h");
    assert(hand.rank == "3 of a Kind")
  }

  test("Pair") {
    val hand = new ThreeCardHand("3s Qs Qc");
    assert(hand.rank == "Pair")
  }

  test("High Card") {
    val hand = new ThreeCardHand("3s Qs Kc");
    assert(hand.rank == "High Card")
  }

  test("high card over high card") {
    assert( new ThreeCardHand("5c Ks Qd") > new ThreeCardHand("2s 5d Qh"))
  }

  test("high card == high card") {
    assert( new ThreeCardHand("5c Ks Qd") == new ThreeCardHand("5s Kc Qs"))
  }
}
