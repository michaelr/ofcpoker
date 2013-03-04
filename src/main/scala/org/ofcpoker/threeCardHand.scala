package org.ofcpoker
import org.ofcpoker.HandRank._

class ThreeCardHand ( val c :List[Card] ) extends Hand(c, 3) {
  require(cards.length == 3)

  def this(cards :String) = this(cards.split(" ").map(new Card(_)).toList)

  override val rank :HandRank =
    rankCombos match {
      case List(3)   => ThreeOfAKind
      case List(2,1) => Pair
      case _         => HighCard
    }

}
