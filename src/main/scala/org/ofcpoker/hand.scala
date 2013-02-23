package org.ofcpoker

abstract class Hand ( val cards :List[Card], val cardsInHand :Int ) extends Ordered[Hand]{
  require (cards.length == cardsInHand)

  val sortedCards = cards.sorted.reverse
  val rank        = this.computeRank;
  val rankValue :Int =
    List( "Royal Flush", "Straight Flush", "4 of a Kind",
          "Full House", "Flush", "3 of a Kind", "Two Pair",
          "Pair", "Straight", "High Card").reverse.indexOf(rank);

  def this(cards :String) = this(cards.split(" ").map(new Card(_)).toList, cards.split(" ").length )

  override def toString = cards.mkString(" ")

  def computeRank :String = {
    if( this.isRoyal )          return "Royal Flush"
    if( this.isStraightFlush )  return "Straight Flush"
    if( this.is4OfAKind)        return "4 of a Kind"
    if( this.isFullHouse)       return "Full House"
    if( this.isFlush )          return "Flush"
    if( this.is3OfAKind)        return "3 of a Kind"
    if( this.isTwoPair)         return "Two Pair"
    if( this.isPair)            return "Pair"
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

  private def isPair :Boolean = {
    rankCombos == List(2,1,1,1)
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

  protected def rankCombos :List[Int] = {
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

  def compare(that :Hand) :Int = {
    if(this.rankValue != that.rankValue)
      return this.rankValue.compare(that.rankValue)

    for( i <- 0 to cardsInHand - 1) {
      val cardCompare = this.sortedCards(i).compare(that.sortedCards(i))
      if( cardCompare != 0 )
        return cardCompare
    }
    return 0
  }

  // XXX this needs to be fixed. see ch. 30 programming in scala
  def equals(that :Hand) :Boolean = {
    return this.compare(that) == 0
  }
  def ==(that :Hand) :Boolean = this equals that
}
