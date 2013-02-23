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

  test("Flush") {
    val hand = new Hand("Ks As 5s 8s 4s");
    assert(hand.rank == "Flush")
  }

  test("Straight") {
    val hand = new Hand("Ac Ts Qd Ks Jh");
    assert(hand.rank == "Straight")
  }

  test("Wheel Straight") {
    val hand = new Hand("Ac 2s 3d 4s 5h");
    assert(hand.rank == "Straight")
  }

  test("Royal Flush") {
    val hand = new Hand("Ac Tc Qc Kc Jc");
    assert(hand.rank == "Royal Flush")
  }

  test("Straight Flush") {
    val hand = new Hand("9c Tc Qc Kc Jc");
    assert(hand.rank == "Straight Flush")
  }

  test("4 of a kind") {
    val hand = new Hand("Jc 2c 2c 2c 2c");
    assert(hand.rank == "4 of a Kind")
  }

}
