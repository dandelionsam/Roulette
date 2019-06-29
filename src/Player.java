import java.util.ArrayList;

public class Player {
    private String name;
    private Double credit;
    private ArrayList<Bet> bets;

    public Player(String name, Double credit){
        this.name = name;
        this.credit = credit;
        this.bets = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name){ this.name = name; }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit){ this.credit = credit; }

    public ArrayList<Bet> getBets() { return bets; }

    public boolean addBet(Bet bet){
        if (this.credit < bet.getAmount()) return false;
        else{
            this.bets.add(bet);
            this.credit -= bet.getAmount();
        }
        return true;
    }

    public String printBets(){
        String res = this.toString(); res += "\r\n";

        for (Bet b : this.bets){
            res += b.getType() == Bet.BetType.CARDINALITY ? "CARDIN" : b.getType();
            res += "\t |" + b.toString() + "\t |" + b.getAmount() + "\r\n";
        }
        return res;
    }

    @Override
    public String toString(){
        return this.getName() + " - " + this.getCredit();
    }
}
