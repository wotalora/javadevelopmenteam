public class Player extends BasePlayer {
    private double bet;
    private double totalCash; 

    public Player(String id, double balance) {
        super(id, balance);
        this.bet = 0;
        this.totalCash = 0;
    }

    int getTotalScore() {  
        return super.getHands().get(0).getScores().get(0);
    }

    boolean placeBet(double bet) {
        if (bet != 0.0 || bet > super.getBalance()) {
            super.reduceBalance(bet);
            return true; 
        }
        return false; 
    }

    void addToHand(Hand playerHand) {
        super.addHand(playerHand);
    }
    
}
