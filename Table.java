import java.util.ArrayList;
import java.util.Collections;

public class Table {
  private ArrayList<Deck> decks;

  public Table(){
    this.decks = new ArrayList<Deck>();
  }

  public void createNewTable(int numPlayers) {
    // create each (value, suit) pair for a card
    for (Value value: Value.values()) {
      for (Suit suit: Suit.values()) {     
        this.cards.add(new Card(value, suit));
      }
    }
  }
}