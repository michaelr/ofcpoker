import org.scalatest.FunSuite
import org.ofcpoker._

class DeckSuite extends FunSuite {
  test("New Deck") {
    val deck = new Deck
    assert(deck.cardsLeft == 52)
  }

  test("deal") {
    val deck = new Deck
    assert(deck.deal.isInstanceOf[Card])
    assert(deck.cardsLeft == 51)
  }
}
