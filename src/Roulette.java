import java.util.ArrayList;
import java.util.Random;

public class Roulette {

    private Slot[] slots = new Slot[37];
    private ArrayList<Player> players;
    private Slot winningSlot;

    public Roulette() {
        slots[0] = new Slot(0, Slot.SlotColor.GREEN, Slot.SlotType.ZERO);
        slots[1] = new Slot(1, Slot.SlotColor.RED, Slot.SlotType.ODD);
        slots[2] = new Slot(2, Slot.SlotColor.BLACK, Slot.SlotType.EVEN);
        slots[3] = new Slot(3, Slot.SlotColor.RED, Slot.SlotType.ODD);
        slots[4] = new Slot(4, Slot.SlotColor.BLACK, Slot.SlotType.EVEN);
        slots[5] = new Slot(5, Slot.SlotColor.RED, Slot.SlotType.ODD);
        slots[6] = new Slot(6, Slot.SlotColor.BLACK, Slot.SlotType.EVEN);
        slots[7] = new Slot(7, Slot.SlotColor.RED, Slot.SlotType.ODD);
        slots[8] = new Slot(8, Slot.SlotColor.BLACK, Slot.SlotType.EVEN);
        slots[9] = new Slot(9, Slot.SlotColor.RED, Slot.SlotType.ODD);
        slots[10] = new Slot(10, Slot.SlotColor.BLACK, Slot.SlotType.EVEN);
        slots[11] = new Slot(11, Slot.SlotColor.BLACK, Slot.SlotType.ODD);
        slots[12] = new Slot(12, Slot.SlotColor.RED, Slot.SlotType.EVEN);
        slots[13] = new Slot(13, Slot.SlotColor.BLACK, Slot.SlotType.ODD);
        slots[14] = new Slot(14, Slot.SlotColor.RED, Slot.SlotType.EVEN);
        slots[15] = new Slot(15, Slot.SlotColor.BLACK, Slot.SlotType.ODD);
        slots[16] = new Slot(16, Slot.SlotColor.RED, Slot.SlotType.EVEN);
        slots[17] = new Slot(17, Slot.SlotColor.BLACK, Slot.SlotType.ODD);
        slots[18] = new Slot(18, Slot.SlotColor.RED, Slot.SlotType.EVEN);
        slots[19] = new Slot(19, Slot.SlotColor.RED, Slot.SlotType.ODD);
        slots[20] = new Slot(20, Slot.SlotColor.BLACK, Slot.SlotType.EVEN);
        slots[21] = new Slot(21, Slot.SlotColor.RED, Slot.SlotType.ODD);
        slots[22] = new Slot(22, Slot.SlotColor.BLACK, Slot.SlotType.EVEN);
        slots[23] = new Slot(23, Slot.SlotColor.RED, Slot.SlotType.ODD);
        slots[24] = new Slot(24, Slot.SlotColor.BLACK, Slot.SlotType.EVEN);
        slots[25] = new Slot(25, Slot.SlotColor.RED, Slot.SlotType.ODD);
        slots[26] = new Slot(26, Slot.SlotColor.BLACK, Slot.SlotType.EVEN);
        slots[27] = new Slot(27, Slot.SlotColor.RED, Slot.SlotType.ODD);
        slots[28] = new Slot(28, Slot.SlotColor.BLACK, Slot.SlotType.EVEN);
        slots[29] = new Slot(29, Slot.SlotColor.BLACK, Slot.SlotType.ODD);
        slots[30] = new Slot(30, Slot.SlotColor.RED, Slot.SlotType.EVEN);
        slots[31] = new Slot(31, Slot.SlotColor.BLACK, Slot.SlotType.ODD);
        slots[32] = new Slot(32, Slot.SlotColor.RED, Slot.SlotType.EVEN);
        slots[33] = new Slot(33, Slot.SlotColor.BLACK, Slot.SlotType.ODD);
        slots[34] = new Slot(34, Slot.SlotColor.RED, Slot.SlotType.EVEN);
        slots[35] = new Slot(35, Slot.SlotColor.BLACK, Slot.SlotType.ODD);
        slots[36] = new Slot(36, Slot.SlotColor.RED, Slot.SlotType.EVEN);

        players = new ArrayList<>();
    }

    public Slot slotExtractor() {
        Random rnd = new Random();
        Slot s = slots[rnd.nextInt(37)];
        this.setWinningSlot(s);
        return s;
    }

/*    public String slotToString(Slot slot) {
        return slot.getNumber() + "\t" + slot.getType() + " \t" + slot.getColor();
    }*/

    public void setWinningSlot(Slot slot) { this.winningSlot = slot; }

    public void addPlayer (Player player){ this.players.add(player); }

    public void addPlayer(String name, Double credit) {
        this.players.add(new Player(name, credit));
    }

    public void removePlayer(String name) {
        for (Player p : players) {
            if (p.getName().equalsIgnoreCase(name))
                players.remove(p);
        }
    }

    public void openBetRound() {
        for (Player p : players) {
            p.getBets().clear();
        }
    }

    public boolean registerBet(Player player, Bet.BetType type, Object par, Double amount) {
        for (Player p : this.players) {
            if (p.equals(player)) {
                if (!(p.addBet(new Bet(type, par, amount)))) return false;
            }
        }
        return true;
    }

    public void checkWins(Slot winningSlot){

        System.out.println(this.winningSlot);

        for (Player p : this.players){
            for (Bet bp : p.getBets()){
                if (bp.getNumber() == winningSlot.getNumber()){
                    p.setCredit(p.getCredit() + bp.getAmount() * 36.00);
                    System.out.println("Scommessa vincente");
                } else if (bp.getNumber() != winningSlot.getNumber() && bp.getColor() == winningSlot.getColor()){
                    p.setCredit(p.getCredit() + bp.getAmount() * 18.00);
                    System.out.println("Scommessa vincente");
                } else if (bp.getNumber() != winningSlot.getNumber() && bp.getCardinality() == winningSlot.getType()){
                    p.setCredit(p.getCredit() + bp.getAmount() * 18.00);
                    System.out.println("Scommessa vincente");
                } else if (bp.getNumber() != winningSlot.getNumber() && bp.getColumn() == winningSlot.getSlotCol()){
                    p.setCredit(p.getCredit() + bp.getAmount() * 12.00);
                    System.out.println("Scommessa vincente");
                } else if (bp.getNumber() != winningSlot.getNumber() && bp.getTwelveth() == winningSlot.getSlotTwelveth()){
                    p.setCredit(p.getCredit() + bp.getAmount() * 12.00);
                    System.out.println("Scommessa vincente");
                }
            }
        }
    }
}
