import org.scalatest.FunSuite
import org.ofcpoker._

class OFCHandSuite extends FunSuite {
  test("New OFCHand") {
    val ofchand = new OFCHand
    assert(ofchand.complete == false)
  }

  test("complete") {
    val ofchand = new OFCHand(
      Array[Card](
        new Card("As"),
        new Card("Kd"),
        new Card("4c")
      ),
      Array[Card](
        new Card("Ad"),
        new Card("Ks"),
        new Card("Kc"),
        new Card("2c"),
        new Card("Tc")
      ),
      Array[Card](
        new Card("Qd"),
        new Card("Qs"),
        new Card("Jc"),
        new Card("Jd"),
        new Card("5c")
      ))

    assert(ofchand.complete == true)
  }

  test("empty hand is not misset") {
    val ofchand = new OFCHand
    assert(ofchand.misset == false)
  }

  test("misset hand") {
    val ofchand = new OFCHand(
      Array[Card](
        new Card("As"),
        new Card("Ad"),
        new Card("4c")
      ),
      Array[Card](
        new Card("3d"),
        new Card("Ks"),
        new Card("Kc"),
        new Card("2c"),
        new Card("Tc")
      ),
      Array[Card](
        new Card("Qd"),
        new Card("Qs"),
        new Card("Jc"),
        new Card("Jd"),
        new Card("5c")
      ))

    assert(ofchand.misset == true)
  }

  test("correctly set hand") {
    val ofchand = new OFCHand(
      Array[Card](
        new Card("As"),
        new Card("Kd"),
        new Card("4c")
      ),
      Array[Card](
        new Card("Ad"),
        new Card("Ks"),
        new Card("Kc"),
        new Card("2c"),
        new Card("Tc")
      ),
      Array[Card](
        new Card("Qd"),
        new Card("Qs"),
        new Card("Jc"),
        new Card("Jd"),
        new Card("5c")
      ))

    assert(ofchand.misset == false)
  }

}
