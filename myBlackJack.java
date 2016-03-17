import java.util.ArrayList;

// enums for creating a card
public enum Value {
  ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
}

public enum Suit {
  HEART, DIAMOND, SPADE, CLUB
}


public class Card {
  private Value value;
  private Suit suit;

  public Card(Value value, Suit suit){
    this.value = value;
    this.suit = suit;
  }

  public Value getValue() {
    return this.value;
  }

  public String toString() {
    return this.value.toString() + " of " + this.suit.toString();
  }
}


public class Deck {
  private ArrayList<Card> cards;

  public Deck(){
    this.cards = new ArrayList<Card>();
  }

  public void createNewDeck() {
    // create each (value, suit) pair for a card
    for (Value value: Value.values()) {
      for (Suit suit: Suit.values()) {     
        this.cards.add(new Card(value, suit));
      }
    }
  }

  public String toString() {
    String cardListString = "";
    for (Card card: this.cards) {
      cardListString += "\n " + card.toString();
    }
    return cardListString;
  }
}



public class Blackjack {

  public static void main(String[] args) {
    System.out.println("********* Blackjack *********");
    Deck playingDeck = new Deck();
    playingDeck.createNewDeck();
    System.out.println(playingDeck);
  }
}