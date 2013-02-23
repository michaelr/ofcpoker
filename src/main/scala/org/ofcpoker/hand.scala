package org.ofcpoker

class Hand ( val cards :List[Card] ) {
  require(cards.length == 5);

  val sortedCards = cards.sorted.reverse

  def this(cards :String) = this(cards.split(" ").map(new Card(_)).toList)

  override def toString = cards.mkString(" ")

  def rank :String = {
    if( this.isRoyal )          return "Royal Flush"
    if( this.isStraightFlush )  return "Straight Flush"
    if( this.is4OfAKind)        return "4 of a Kind"
    if( this.isFullHouse)       return "Full House"
    if( this.isFlush )          return "Flush"
    if( this.is3OfAKind)        return "3 of a Kind"
    if( this.isTwoPair)         return "Two Pair"
    if( this.isStraight)        return "Straight"
                                return "High Card"
  }

  private def is4OfAKind :Boolean = {
    rankCombos == List(4,1)
  }

  private def is3OfAKind :Boolean = {
    rankCombos == List(3,1,1)
  }

  private def isTwoPair :Boolean = {
    rankCombos == List(2,2,1)
  }

  private def isFullHouse :Boolean = {
    rankCombos == List(3,2)
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
      case List(9,1,1,1) => true // A 5 4 3 2
      case _             => false
    }
  }

  private def rankCombos :List[Int] = {
    val cardRanks = cards.map(_.rank);
    val distinctRanks = cardRanks.distinct;
    distinctRanks
      .map(x => cardRanks.count(y => x == y))
      .sorted
      .reverse
  }

  private def rankDifference :List[Int]= {
    sortedCards
      .map(_.rankInt)
      .sliding(2,1)
      .toList
      .map(pair => pair(0) - pair(1))
  }

}
