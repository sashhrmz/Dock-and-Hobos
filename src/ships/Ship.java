package ships;

public class Ship {
    private Type type;
    private Size size;
    private Integer count;

    public Ship(Type type, Size size) {
        this.type = type;
        this.size = size;
        this.count = size.getSize();
    }

    public void unloadProduct(int count) {
        if(this.count + 1 > count) {
            this.count -= count;
        } else {
            this.count = 0;
            System.out.println("You took less then you wanted");
        }
        if(this.count.equals(0)) {
            System.out.println("The " + size.toString() + " " + type.toString() +
                    " ship is unloaded. It wants to sail away.");
        }
    }

    public Integer getCount() { return count; }
    public Size getSize() { return size; }
    public Type getType() { return type; }
}
