package Hobos;

import Port.Pier;
import ships.Type;

import java.util.ArrayList;

public class Hobo extends Thread {
    private ArrayList<Pier> piers;
    private Type request;
    private Home home;

    public Hobo(ArrayList<Pier> piers, boolean pilferer, Home home) {
        this.piers = piers;
        this.home = home;
    }

    public void setRequest(Type type) { request = type; }

    @Override
    public void run() {
       home.eat();
    }

}
