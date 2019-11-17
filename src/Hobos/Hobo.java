package Hobos;

import Port.Pier;
import ships.Type;

import java.util.ArrayList;

public class Hobo extends Thread {
    private volatile ArrayList<Pier> piers;
    private Type request;
    private volatile Task task;
    private Home home;

    public Hobo(ArrayList<Pier> piers, Home home) {
        this.home = home;
        this.piers = piers;
        task = Task.NONE;
    }

    @Override
    public void run() {
        while (true) {
            if(task == Task.NONE) {
                task = home.whatIamGonnaDo();
            } else if(task == Task.COOK) {
                cook();
            } else if(task == Task.STEAL) {
                request = home.setRequest();
                steal();
            } else if(task == Task.EAT) {
                home.eat();
                task = Task.NONE;
            }
        }
    }

    public void setTask(Task task) { this.task = task; }

    public synchronized void steal() {
        for(Pier pier : piers) {
            if (pier.getType() == request && pier.checkToSteal()) {
                pier.get();
                System.out.println("One " + request.toString() +
                        " was stolen.");
                home.incStorage(request);
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void cook() {
            boolean isCooked = home.tryMakeSandwich();
            if (isCooked) {
               home.callHobosForSupper();
            }
    }
}
