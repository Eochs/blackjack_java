public class Blackjack {

  public static void main(String[] args) {
    System.out.println("********* Blackjack *********");
    Deck playingDeck = new Deck();
    playingDeck.createNewDeck();
    System.out.println(playingDeck);
  }
}