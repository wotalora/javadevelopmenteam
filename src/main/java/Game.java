import java.util.List;
import java.util.Scanner;

public class Game {
    private final Player player;
    private final Dealer dealer;
    private final int MAX_NUM_OF_DECKS = 1;
    private final Shoe shoe;
    private double bet; 

    public Game(Player player, Dealer dealer) {
        this.player = player;
        this.dealer = dealer;
        this.shoe = new Shoe(MAX_NUM_OF_DECKS);
    }

    public void playAction(String action, Hand hand, Hand dealerHand) {
        switch (action) {
            case "hit" -> {
                hit(hand, dealerHand);               
            }
            case "stand" -> {
                stand();
            }
            case "quit" -> {
                System.exit(0); 
            }
            default -> {
                System.out.println("Invalid move");
            }
        }
        // Do nothing
    }

    public void hit(Hand hand, Hand dealerHand) {
        Card returned = hand.addCard(shoe.dealCard());
        Card dealerRet = dealerHand.addCard(shoe.dealCard()); 
        
        System.out.println("You hit: " + returned.getSuit() + " of value " + returned.getFaceValue()
        + " card."
        ); 
        System.out.println("Your game score now is: " + player.getTotalScore()); 
        
        System.out.println("\nDealer hit: " + dealerRet.getSuit() + " of value " + dealerRet.getFaceValue()
        + " card."); 
        
        if (player.getTotalScore() >= 21) {
            stand(); 
        }
    }

    public void stand() {
        int dealerScore = dealer.getTotalScore();
        int playerScore = player.getTotalScore();
        List<Hand> hands = player.getHands();

        for (Hand hand : hands) {
            int bestScore = hand.resolveScore();
            
            if (playerScore == 21) {
                player.increaseBalance(3.00 * bet);
                dealer.reduceBalance(3.00 * bet); 
                System.out.println("\nYou Won!\n"); 
            } else if (dealerScore == 21) {
                player.reduceBalance(3.00 * bet);
                dealer.increaseBalance(3.00 * bet); 
                System.out.println("\nYou Lost!\n");
            } else if (playerScore > dealerScore && playerScore <= 21) {
                player.increaseBalance(2.00 * bet); 
                dealer.reduceBalance(2.00 * bet);  
                System.out.println("\nYou Won!\n"); 
            } else if (playerScore < dealerScore && dealerScore <= 21) {
                player.reduceBalance(bet);
                dealer.increaseBalance(bet); 
                System.out.println("\nYou Lost!\n"); 
            } else if (playerScore < dealerScore && dealerScore > 21) {
                player.increaseBalance(2.00 * bet); 
                dealer.reduceBalance(2.00 * bet);
                System.out.println("\nYou Won!\n"); 
            } else if (playerScore > 21 && dealerScore < 21) {
                player.reduceBalance(2.00 * bet); 
                dealer.increaseBalance(2.00 * bet);  
                System.out.println("\nYou Lost!\n"); 
            } else if (dealerScore > 21 && playerScore < 21) {
                player.increaseBalance(2.00 * bet); 
                dealer.reduceBalance(2.00 * bet);  
                System.out.println("\nYou Won!\n"); 
            } else { 
                player.increaseBalance(bet);
                System.out.println("\nTie!\n"); 
            }
        }
        
        System.out.println("Your Score: " + player.getTotalScore()); 
        
        System.out.println("Dealer Score: " + dealer.getTotalScore()); 
        
        System.out.println("Final Balance Player: " + player.getBalance());
        
        System.exit(0); 
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("WELCOME TO THE CLI BLACKJACK GAME!"); 
        System.out.println("DECK CARD SIZE: " + MAX_NUM_OF_DECKS * 52); 
        
        System.out.println("\nPress Enter to continue..."); 
        scanner.nextLine(); 
        
        System.out.println("\nWhat is your bet ? "); 
        bet = scanner.nextInt();
        player.placeBet(bet);

        Hand playerHand = new Hand(shoe.dealCard());
        player.addToHand(playerHand);

        Hand dealerHand = new Hand(shoe.dealCard());
        dealer.addToHand(dealerHand);
        
        System.out.println("\nYour New Balance: " + player.getBalance()); 
        System.out.println("\nYour First Hand: " + player.getFirstHandCard().getSuit() + " of " + " value " + 
                player.getFirstHandCard().getFaceValue());
        
        while (true) {
            List<Hand> hands = player.getHands(); 
            List<Hand> dealerHands = dealer.getHands(); 
            for (Hand hand: hands) {
                String action = getUserAction(scanner);
                playAction(action, hand, dealerHand); 
                if (action.equals("stand")) {
                    break; 
                }
            }
        }
    }

    public String getUserAction(Scanner scanner) {
        System.out.println("\n\n BLACKJACK Game\n\n"
                + "To Proceed with the game: \n"
                + "1. Enter hit to hit.\n"
                + "2. Enter stand to stand.\n"
                + "3. Enter quit to quit. \n"
                + "NOTE: Press Enter first to procced next round!"
        );
        
        scanner.nextLine(); 
        
        String userInput = scanner.nextLine(); 
        
        return userInput; 
    }

    public static void main(String[] args) {
        Player player = new Player("firstPlayer", 1000);
        Dealer dealer = new Dealer("secondPlayer", 2000);
        Game game = new Game(player, dealer);
        game.start();
    }
    
}
