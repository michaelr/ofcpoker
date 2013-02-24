package org.ofcpoker

class Deck {
  val deck =
    "AKQJT98765432".split(".").map(rank =>
      "schd".split(".").map(suit => new Card(rank + suit)))
    .flatten.toArray
}
