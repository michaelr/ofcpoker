package org.ofcpoker

class Hand ( val cards :List[Card] ) {
  require(cards.length == 5);

  val sortedCards = cards.sorted.reverse

  def this(cards :String) = this(cards.split(" ").map(new Card(_)).toList)

  override def toString = cards.mkString(" ")

  def rank :String = {
    if( this.isFlush ) return "Flush"
    return "High Card"
  }

  def isFlush :Boolean = {
    return cards.map(_.suit).distinct.size == 1;
  }

}
