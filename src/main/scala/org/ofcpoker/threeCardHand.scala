package org.ofcpoker

class ThreeCardHand ( val c :List[Card] ) extends Hand(c, 3) {
  require(cards.length == 3)

  def this(cards :String) = this(cards.split(" ").map(new Card(_)).toList)

  override def computeRank :String = {
    rankCombos match {
      case List(3)   => "3 of a Kind"
      case List(2,1) => "Pair"
      case _         => "High Card"
    }
  }

}
