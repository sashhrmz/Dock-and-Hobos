package Hobos;

import ships.Type;

import java.util.ArrayList;

public class Hobo extends Thread {
    private ArrayList<Storage> storage;
    private Type request;
    private Home home;

    public Hobo(ArrayList<Storage> storage, Home home) {
        this.home = home;
        this.storage = storage;
    }

    public void setRequest() {
        Type type = Type.SAUSAGE;
        for(Storage storage : this.storage) {
            if(!storage.checkCount()) {
                type = storage.getType();
                break;
            }
        }
        request = type;
    }


    @Override
    public void run() {
        while (true) {
            setRequest();
            try {
                home.stealing(request);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (storage.get(0).checkCount() &&
                    storage.get(1).checkCount() &&
                    storage.get(2).checkCount()) {
                try {
                    home.eat();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
