package Hobos;

import Port.Pier;
import ships.Type;

import java.util.ArrayList;

public class Home extends Thread {
    private volatile ArrayList<Storage> storage;
    private volatile ArrayList<Pier> piers;

    private volatile int counter;
    private volatile int sleepCounter;

    public Home(ArrayList<Storage> storage, ArrayList<Pier> piers) {
        this.storage = storage;
        this.piers = piers;
        counter = 0;
        sleepCounter = 0;
    }


    private void addToStorage(Type type) {
        for(Storage storage : this.storage) {
            if(storage.getType() == type) {
                storage.add();
            }
        }
    }

    public synchronized void stealing(Type type) throws InterruptedException {
        ++counter;
        if (counter < 3) {
            wait();
        } else if (counter < 9) {
            for(Pier pier : piers) {
                if(pier.getType() == type && pier.checkToSteal()) {
                    pier.get();
                    addToStorage(type);
                    System.out.println("One " + type.toString() +
                            " was stolen.");
                }
            }
            sleep(3000);
            System.out.println("Hobo bring the " + type.toString() + " to the storage");
        }
        if (counter == 8) {
            notifyAll();
            counter = 0;
        }
    }

    public synchronized void eat() throws InterruptedException {
        ++sleepCounter;
        if(sleepCounter < 8) {
            wait();
        } else {
            storage.get(0).makeSandwiches();
            storage.get(1).makeSandwiches();
            storage.get(2).makeSandwiches();
            sleep(1000);
            System.out.println("Hobos ate. They are going to steal again.");
            sleepCounter = 0;
            notifyAll();
        }
    }
}