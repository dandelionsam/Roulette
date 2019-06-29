public class Bet {

    public enum BetType{
        NUMBER,
        CARDINALITY,
        COLOR,
        TWELVETH,
        COLUMN
    }

    private Double amount;
    private BetType type;

    private int number;
    private Slot.SlotType cardinality;
    private Slot.SlotColor color;
    private int twelveth;
    private int column;

    public Bet (BetType type, Object par, Double amount){

        this.type = type;
        this.amount = amount;

        this.number = -1;
        this.cardinality = null;
        this.color = null;
        this.twelveth = -1;
        this.column = -1;

        switch(type){
            case NUMBER: { this.number = (int) par;} break;
            case CARDINALITY: { this.cardinality = (Slot.SlotType) par;} break;
            case COLOR: { this.color = (Slot.SlotColor) par;} break;
            case COLUMN: { this.column = (int) par;} break;
            case TWELVETH: { this.twelveth = (int) par;} break;
        }
    }

    /**
     * Si può optare per una soluzione più elegante, creando n costruttori con due paramentri (par, amount) per ogni tipologia di scommessa accettata, assegnando il tipo di scommessa
     * a seconda del parametro di ingresso del costruttore
     *
     * public Bet ( ...type of bet..., amount) x n times
     * */

    public Double getAmount() {
        return amount;
    }

    public BetType getType() {
        return type;
    }

    public int getNumber() {
        return number;
    }

    public Slot.SlotType getCardinality() {
        return cardinality;
    }

    public Slot.SlotColor getColor() {
        return color;
    }

    public int getTwelveth() {
        return twelveth;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public String toString(){
        String res = "";

        if (this.number != -1){ res += this.number;}
        if (this.color != null){ res += this.color;}
        if (this.cardinality != null){ res += this.cardinality;}
        if (this.column != -1){ res += this.column;}
        if (this.twelveth != -1){ res += this.twelveth;}

        return res;
    }
}
