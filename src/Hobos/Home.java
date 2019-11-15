package Hobos;

import ships.Type;

import java.util.ArrayList;

public class Home extends Thread {
    private ArrayList<Storage> storage;

    public Home(ArrayList<Storage> storage) {
        this.storage = storage;
    }

    public synchronized void eat() {

    }
    
    
}

class Storage {
    private Type type;
    private int count;

    public Storage(Type type, int count) {
        this.type = type;
        this.count = count;
    }

    public boolean checkCount() { return count > 8; }

    public void makeSandwiches() { count -= 8; }

    public int getCount() { return count; }

    public Type getType() { return type; }
}