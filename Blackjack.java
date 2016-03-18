import java.util.Scanner;

public class Blackjack {

  public static void main(String[] args) {
    System.out.println("********* Blackjack *********");
    Deck playingDeck = new Deck();
    playingDeck.createNewDeck();
    playingDeck.shuffle();
    //System.out.println(playingDeck);

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
        continue; // TODOD: make sure this workes
      }
      // start dealing
      playerHand.draw(playingDeck);
      playerHand.draw(playingDeck);

      dealerHand.draw(playingDeck);
      dealerHand.draw(playingDeck);

      boolean roundHasEnded = false;

      // player hit
      while (true) {
        System.out.println("Your current hand:");
        System.out.print(playerHand.toString());
        System.out.println("\nYour hand has a value of: "+ playerHand.totalDeckValue());
        if (playerHand.totalDeckValue() == 21) {
          System.out.println("Lucky 21! Congrats you win!");
          playerMoney += 1.5 * bet;
          roundHasEnded = true;
          break;
        }
        System.out.println("Dealer's hand: "+ dealerHand.getCard(0).toString() + " and [Hidden Card]");

        System.out.println("Enter: 1 to Hit. 2 to Stand. 3 to Split. 4 to Double Down.");
        int response = userInput.nextInt();

        if (response == 1) {
          playerHand.draw(playingDeck);
          System.out.println("You drew a " + playerHand.getCard(playerHand.deckSize()-1).toString());

          if (playerHand.totalDeckValue() > 21) {
            System.out.println("Busted. Your hand is " + playerHand.totalDeckValue());
            playerMoney -= bet;
            roundHasEnded = true;
            break;
          }
        } else if (response == 2) {
          break;
        } else if (response == 3) {
          break;
        } else if (response == 4) {
          break;
        } else {
          System.out.println("Please enter valid response.");
          continue;
        }
      }
      // Dealer's turn
      System.out.println("Dealer's hand: " + dealerHand.toString());
      // Dealer draws
      while ((dealerHand.totalDeckValue() < 17) && !roundHasEnded) {
        dealerHand.draw(playingDeck);
        System.out.println("Dealer draws the " + dealerHand.getCard(dealerHand.deckSize()-1).toString());
      }
      System.out.println("Dealer's hand is worth " + dealerHand.totalDeckValue());

      
      
      // dealer busted
      if ((dealerHand.totalDeckValue() > 21) && !roundHasEnded) {
        System.out.println("Dealer has busted. You win!");
        if (playerHand.totalDeckValue() == 21) {
          playerMoney += 1.5 * bet; // win 150% of bet if had 21
        } else {
          playerMoney += bet;
        }
        roundHasEnded = true;
      }
      // push
      if ((playerHand.totalDeckValue() == dealerHand.totalDeckValue()) && !roundHasEnded) {
        System.out.println("Push");
        roundHasEnded = true;
      }
      // dealer has beat player
      if (dealerHand.totalDeckValue() > playerHand.totalDeckValue() && !roundHasEnded) {
        System.out.println("The Dealer has won.");
        playerMoney -= bet;
        roundHasEnded = true;
      }
      // player has beat dealer
      if ((playerHand.totalDeckValue() > dealerHand.totalDeckValue()) && !roundHasEnded) {
        System.out.println("You win the hand!");
        playerMoney += bet;
        roundHasEnded = true;
      }

      // clean up
      playerHand.returnCardsToDeck(playingDeck);
      dealerHand.returnCardsToDeck(playingDeck);
      System.out.println("End of hand");
    }

    System.out.println("You are out of funds. Game over.");

  }
}