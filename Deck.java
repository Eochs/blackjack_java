import java.util.ArrayList;
import java.util.Collections;

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

  public void shuffle() {
    Collections.shuffle(this.cards);
  }

  public String toString() {
    String cardListString = "";
    for (Card card: this.cards) {
      cardListString += "\n " + card.toString();
    }
    return cardListString;
  }
}