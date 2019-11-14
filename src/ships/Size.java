package ships;

public enum Size {
    SMALL  (10),
    MEDIUM (20),
    BIG    (30);

    private final int sizeValue;

    Size(int sizeValue) {
        this.sizeValue = sizeValue;
    }

    public int getSize() { return sizeValue; }
}
