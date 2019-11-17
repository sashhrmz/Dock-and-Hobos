package Hobos;

import ships.Type;

import java.util.ArrayList;

public class Home extends Thread {

    private volatile ArrayList<Hobo> hobos;
    private volatile int counter;
    private volatile int eaters;
    private volatile int sausageCounter;
    private volatile int mayonnaiseCounter;
    private volatile int breadCounter;

    public Home() {
        counter = 0;
        eaters = 0;
        sausageCounter = 0;
        mayonnaiseCounter = 0;
        breadCounter = 0;
    }

    public void setHobos(ArrayList<Hobo> hobos) {
        this.hobos = hobos;
        System.out.println(hobos.size());
    }

    public synchronized Type setRequest() {
        Type type = null;
        if(mayonnaiseCounter < 8) {
            type = Type.MAYONNAISE;
        } else if (breadCounter < 8) {
            type = Type.BREAD;
        } else if(sausageCounter < 8) {
            type = Type.SAUSAGE;
        }
        return type;
    }

    public synchronized void incStorage(Type type) {
        if(type == Type.SAUSAGE) {
            ++sausageCounter;
            System.out.println("Add one sausage to storage.");
        } else if(type == Type.MAYONNAISE) {
            ++mayonnaiseCounter;
            System.out.println("Add one mayonnaise to storage.");
        } else {
            ++breadCounter;
            System.out.println("Add one bread to storage.");
        }
    }

    public synchronized boolean tryMakeSandwich(){
        if(sausageCounter > 7
                && mayonnaiseCounter > 7
                && breadCounter > 7) {
            sausageCounter -= 8;
            mayonnaiseCounter -=8;
            breadCounter -= 8;
            System.out.println("Supper is ready.");
            return true;
        } else {
            return false;
        }
    }

    public synchronized void eat() {
        ++eaters;
         try {
             System.out.println(eaters);
             if (eaters == 8) {
                 sleep(1000);
                 notifyAll();
                 eaters = 0;
             } else {
                 wait();
             }
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
    }

    public synchronized void callHobosForSupper() {
        for(Hobo hobo : hobos) {
            hobo.setTask(Task.EAT);
        }
    }

    public synchronized Task whatIamGonnaDo() {
        counter = (counter + 1) % 8;
        if (counter < 2 ) {
            return Task.COOK;
        }
        return Task.STEAL;
    }



}