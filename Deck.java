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

  public void addCard(Card cardToAdd) {
    this.cards.add(cardToAdd);
  }

  public void removeCard(int i) {
    this.cards.remove(i);
  }

  public Card getCard(int i) {
    return this.cards.get(i);
  }

  public void draw(Deck drawingFrom) {
    this.cards.add(drawingFrom.getCard(0));
    drawingFrom.removeCard(0);
  }

  public int deckSize() {
    return this.cards.size();
  }

  public void returnCardsToDeck(Deck returnTo) {
    int thisDeckSize = this.cards.size();
    for (int i=0; i<thisDeckSize; i++) {
      returnTo.addCard(this.getCard(i));
    }
    for (int i=0; i<thisDeckSize; i++) {
      this.removeCard(0);
    }
  }

  public int totalDeckValue() {
    int total = 0;
    int aces = 0;
    for (Card card: this.cards) {
      switch (card.getValue()) {
        case ACE: aces += 1; break;
        case TWO: total += 2; break;
        case THREE: total += 3; break;
        case FOUR: total += 4; break;
        case FIVE: total += 5; break;
        case SIX: total += 6; break;
        case SEVEN: total += 7; break;
        case EIGHT: total += 8; break;
        case NINE: total += 9; break;
        case TEN: total += 10; break;
        case JACK: total += 10; break;
        case QUEEN: total += 10; break;
        case KING: total += 10; break;
      }
    }

    for (int i=0; i < aces; i++) {
      if (total > 10) { 
        total += 1; // if ace was 11 then would put total >= 22
      } else {
        total += 11;
      }
    }

    return total;
  }


  public String toString() {
    String cardListString = "";
    for (Card card: this.cards) {
      cardListString += "\n " + card.toString();
    }
    return cardListString;
  }
}