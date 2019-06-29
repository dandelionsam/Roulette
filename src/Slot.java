public class Slot {

    public enum SlotColor{RED, BLACK, GREEN}
    public enum SlotType{ZERO, EVEN, ODD}

    private int number;
    private SlotColor color;
    private SlotType type;

    public Slot (int number, SlotColor color, SlotType type){
        this.number = number;
        this.color = color;
        this.type = type;
    }

    public int getNumber() { return number; }
    public SlotColor getColor() { return color; }
    public SlotType getType() { return type; }

    public int getSlotCol(){

        int col = 0;

        if (this.number == 0) return 0;
        else{
            int[] st = new int[]{1, 4, 7, 10, 13, 16, 19, 22, 25, 28, 31, 34};
            int[] nd = new int[]{2, 5, 8, 11, 14, 17, 20, 23, 26, 29, 32, 35};
            int[] rd = new int[]{3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36};

            for (int i : st) if (this.number == i) col = 1;
            for (int i : nd) if (this.number == i) col = 2;
            for (int i : rd) if (this.number == i) col = 3;
        }

        return col;
    }

    public int getSlotTwelveth(){

        int twe = 0;

        if (this.number == 0) return 0;
        else {
            if (this.number <= 12 && this.number >= 1) twe = 1;
            if (this.number <= 24 && this.number >= 13) twe = 2;
            if (this.number <= 36 && this.number >= 25) twe = 3;
        }

        return twe;
    }

    @Override
    public String toString(){
        return this.number + " " + this.getColor() + " " + this.getType() + " " + this.getSlotCol() + " " + this.getSlotTwelveth();
    }
}
