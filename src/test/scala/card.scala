import org.scalatest.FunSuite
import poker._

class CardSuite extends FunSuite {
  test("create a card") {
    val card = new Card( 3, 'H');
    assert(card.rank === 3);
  }
}
