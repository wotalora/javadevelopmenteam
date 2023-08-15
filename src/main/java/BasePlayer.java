import java.util.ArrayList;
import java.util.List;

public abstract class BasePlayer {
    private String id;
    private double balance;
    private List<Hand> hands;

    public BasePlayer(String id, double balance) {
        this.id = id;
        this.balance = balance;
        this.hands = new ArrayList<>();
    }

    public List<Hand> getHands() {
        return hands;
    }
    
    public Card getFirstHandCard() {
        return hands.get(0).getCards().get(0);
    }

    public void addHand(Hand hand) {
        getHands().add(hand);
    }

    public void removeHand(Hand hand) {
        getHands().remove(hand);
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * @param hands the hands to set
     */
    public void setHands(List<Hand> hands) {
        this.hands = hands;
    }
    
    public void reduceBalance(double balance) {
        this.balance -= balance; 
    }
    
    public void increaseBalance(double balance) {
        this.balance += balance; 
    }
}
