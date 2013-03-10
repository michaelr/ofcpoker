package org.ofcpoker

class OFCHand (
  private val top    :Array[Card],
  private val middle :Array[Card],
  private val bottom :Array[Card] ) {

  require(top.size <= 3 && middle.size <= 5 && bottom.size <= 5)

  def this() = this(Array[Card](), Array[Card](), Array[Card]());

  def complete =
    top.size    == 3 &&
    middle.size == 5 &&
    bottom.size == 5

  def misset :Boolean = {
    if(!complete)
      return false

    if(middleHand < topHand || bottomHand < middleHand)
      return true

    return false
  }

  def topHand    = new ThreeCardHand(top.toList)
  def middleHand = new FiveCardHand(middle.toList)
  def bottomHand = new FiveCardHand(bottom.toList)

  def score(against :OFCHand) :Int = {
    if( !this.complete || !against.complete )
      throw new RuntimeException("Hands must be complete to score")

    return 0
  }

}
