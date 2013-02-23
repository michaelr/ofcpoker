package poker

class Card ( val r :Char, val s :Char ) extends Ordered[Card]{
  val rank = r.toUpper
  val suit = s.toLower
  val rankInt :Int = rank match {
    case 'A' => 14
    case 'K' => 13
    case 'Q' => 12
    case 'J' => 11
    case 'T' => 10
    case  _  => rank.getNumericValue
  }

  require(rank.toString.matches("[23456789TJQKA]"))
  require(suit.toString.matches("[dhsc]"))

  def this(st :String) = this(st.charAt(0), st.charAt(1))

  override def toString = rank.toString + suit.toString

  def compare(that :Card) = this.rankInt.compare(that.rankInt)
}

class Hand ( val cards :List[Card] ) {
  require(cards.length == 5);

  val sortedCards = cards.sorted.reverse

  def this(cards :String) = this(cards.split(" ").map(new Card(_)).toList)

  override def toString = cards.mkString(" ")

}
