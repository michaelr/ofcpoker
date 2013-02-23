package poker

class Card ( val r :Char, val s :Char ) {
  val rank = r.toUpper
  val suit = s.toLower

  require(rank.toString.matches("[23456789TJQKA]"))
  require(suit.toString.matches("[dhsc]"))

  def this(st :String) = this(st.charAt(0), st.charAt(1));

  override def toString = rank.toString + suit.toString

}

class Hand ( val cards :List[Card] ) {
  require(cards.length == 5);

  def this(a :String, b :String, c :String, d :String, e :String)
    = this( List( new Card(a), new Card(b), new Card(c), new Card(d), new Card(e)));
}
