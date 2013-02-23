package org.ofcpoker

class FiveCardHand ( val c :List[Card] ) extends Hand(c, 5) {

  def this(cards :String) = this(cards.split(" ").map(new Card(_)).toList)

}
