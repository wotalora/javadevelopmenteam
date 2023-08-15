public class Dealer extends BasePlayer {
    
    public Dealer(String id, double balance) {
        super(id,  balance);
    }

    

    int getTotalScore() {
        return super.getHands().get(0).getScores().get(0);
    }

    void addToHand(Hand dealerHand) {
        super.addHand(dealerHand);
    }
    
}
