import java.util.Scanner;

public class Blackjack {

  public static void main(String[] args) {
    System.out.println("********* Blackjack *********");
    Deck playingDeck = new Deck();
    playingDeck.createNewDeck();
    playingDeck.shuffle();
    System.out.println(playingDeck);

    // create hands for player and dealer, where hand is a Deck
    Deck playerHand = new Deck();
    Deck dealerHand = new Deck();

    double playerMoney = 500.00; // don't really care about minor rounding errors so use double

    Scanner userInput = new Scanner(System.in);

    // Game loop
    while (playerMoney > 0) {
      System.out.println("You have $"+playerMoney+", enter a number for the amount you want to bet:");
      double bet = userInput.nextDouble();
      if (bet > playerMoney) {
        System.out.println("You have bet too much, please bet within your means.");
        continue;
      }
      // start dealing
      playerHand.draw(playingDeck);
      playerHand.draw(playingDeck);

      dealerHand.draw(playingDeck);
      dealerHand.draw(playingDeck);

      // player hit
      while (true) {
        System.out.println("Your current hand:");
        System.out.print(playerHand.toString());
      }
    }

    System.out.println("You are out of funds. Game over.")
  }
}