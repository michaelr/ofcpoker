package org.ofcpoker

class Deck {
  val deck =
    List("A","K","Q","J","T","9","8","7","6","5","4","3","2")
      .map(rank => List("s","c","h","d")
        .map(suit => new Card(rank + suit)))
      .flatten.toArray

}
