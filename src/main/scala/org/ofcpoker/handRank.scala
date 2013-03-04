package org.ofcpoker

object HandRank extends Enumeration (
  "High Card", "Pair", "Two Pair", "3 of a Kind", "Straight",
  "Flush", "Full House", "4 of a Kind", "Straight Flush",
  "Royal Flush" ) {
  type HandRank = Value
  val HighCard, Pair, TwoPair, ThreeOfAKind, Straight,
    Flush, FullHouse, FourOfAKind, StraightFlush,
    RoyalFlush = Value
}

