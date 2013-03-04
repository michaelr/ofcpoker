import org.scalatest.FunSuite
import org.ofcpoker._
import org.ofcpoker.HandRank._

class FiveCardHandSuite extends FunSuite {
  test("New FiveCardHand") {
    val hand = new FiveCardHand(
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
      val hand = new FiveCardHand(
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
    val hand = new FiveCardHand("As Kd 5c 8h 4s");
  }

  test("hand.toString") {
    assert(new FiveCardHand("As Kd 5c 8h 4s").toString == "As Kd 5c 8h 4s");
  }

  test("hand.sorted") {
    val hand = new FiveCardHand("Kd As 5c 8h 4s");
    assert(hand.sortedCards.mkString(" ") == "As Kd 8h 5c 4s");
  }

  test("Flush") {
    val hand = new FiveCardHand("Ks As 5s 8s 4s");
    assert(hand.rank == Flush)
  }

  test("Straight") {
    val hand = new FiveCardHand("Ac Ts Qd Ks Jh");
    assert(hand.rank == Straight)
  }

  test("Wheel Straight") {
    val hand = new FiveCardHand("Ac 2s 3d 4s 5h");
    assert(hand.rank == Straight)
  }

  test("Royal Flush") {
    val hand = new FiveCardHand("Ac Tc Qc Kc Jc");
    assert(hand.rank == RoyalFlush)
  }

  test("Straight Flush") {
    val hand = new FiveCardHand("9c Tc Qc Kc Jc");
    assert(hand.rank == StraightFlush)
  }

  test("4 of a Kind") {
    val hand = new FiveCardHand("Jc 2c 2d 2s 2h");
    assert(hand.rank == FourOfAKind)
  }

  test("Full House") {
    val hand = new FiveCardHand("Jc Js 2c 2s 2d");
    assert(hand.rank == FullHouse)
  }

  test("Three of a Kind") {
    val hand = new FiveCardHand("Jc Qc 2d 2s 2h");
    assert(hand.rank == ThreeOfAKind)
  }

  test("Two Pair") {
    val hand = new FiveCardHand("Qs Qc 2d 2s 3h");
    assert(hand.rank == TwoPair)
  }

  test("Pair") {
    val hand = new FiveCardHand("3s Qs Qc 2d 4h");
    assert(hand.rank == Pair)
  }

  test("High Card") {
    val hand = new FiveCardHand("3s Qs Kc 2d 4h");
    assert(hand.rank == HighCard)
  }

  test("royal  > two pair") {
    assert( new FiveCardHand("As Ks Qs Js Ts") > new FiveCardHand("Td Th 4s 4c 2d"))
  }

  test("royal == royal") {
    assert( new FiveCardHand("As Ks Qs Js Ts") equals new FiveCardHand("Ad Kd Qd Jd Td"))
  }

  test("flush over flush") {
    assert( new FiveCardHand("5s Ks Qs Js Ts") > new FiveCardHand("2d Kd Qd Jd Td"))
  }

  test("high card over high card") {
    assert( new FiveCardHand("5c Ks Qd Js Ts") > new FiveCardHand("2s 5d Qh Jd Tc"))
  }

  test("high card == high card") {
    assert( new FiveCardHand("5c Ks Qd Js Ts") == new FiveCardHand("5s Kc Qs Jh Td"))
  }
}
