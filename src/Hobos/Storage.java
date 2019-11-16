package Hobos;

import ships.Type;

public class Storage {
    private Type type;
    private int count;

    public Storage(Type type) {
        this.type = type;
        this.count = 0;
    }

    public boolean checkCount() { return count > 8; }

    public void makeSandwiches() { count -= 8; }

    public Type getType() { return type; }

    public void add() { ++count; }
}