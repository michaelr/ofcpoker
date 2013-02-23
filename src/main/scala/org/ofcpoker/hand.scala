package org.ofcpoker

class Hand ( val cards :List[Card] ) {
  require(cards.length == 5);

  val sortedCards = cards.sorted.reverse

  def this(cards :String) = this(cards.split(" ").map(new Card(_)).toList)

  override def toString = cards.mkString(" ")

  def rank :String = {
    if( this.isRoyal )          return "Royal Flush"
    if( this.isStraightFlush )  return "Straight Flush"
    if( this.isFlush )          return "Flush"
    if( this.isStraight)        return "Straight"
                                return "High Card"
  }

  private def isRoyal :Boolean = {
    return sortedCards.last.rank == 'T' && isStraightFlush
  }

  private def isStraightFlush :Boolean = {
    return isFlush && isStraight;
  }

  private def isFlush :Boolean = {
    return cards.map(_.suit).distinct.size == 1;
  }

  private def isStraight :Boolean = {
    return this.rankDifference match {
      case List(1,1,1,1) => true
      case _             => false
    }
  }

  private def rankDifference :List[Int]= {
    return sortedCards
          .map(_.rankInt)
          .sliding(2,1)
          .toList
          .map(pair => pair(0) - pair(1))
  }

}
