package org.ofcpoker

class Deck {
  var deck =
    "AKQJT98765432".flatMap(rank => "schd".map(suit => new Card(rank.toString + suit)))
    .toArray

  def cardsLeft = deck.size
  def isEmpty   = cardsLeft == 0

  def deal :Card = {
    val random = scala.util.Random.nextInt(cardsLeft - 1)
    val nextCard = deck(random)
    deck = (deck take random) ++ (deck drop (random + 1))
    return nextCard;
  }
}
