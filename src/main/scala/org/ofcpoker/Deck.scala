package org.ofcpoker

class Deck {
  val deck =
    "AKQJT98765432".flatMap(rank => "schd".map(suit => new Card(rank.toString + suit)))
    .toArray
}
