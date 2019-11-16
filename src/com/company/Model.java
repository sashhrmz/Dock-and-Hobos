package com.company;

import Hobos.*;
import Port.*;
import ships.*;

import java.util.ArrayList;

public class Model {

    public static void main(String[] args) {
        Tunnel tunnel = new Tunnel();

        Generator generator = new Generator(tunnel);

        Pier breadPier = new Pier(Type.BREAD, tunnel);
        Pier sausagePier = new Pier(Type.SAUSAGE, tunnel);
        Pier mayonnaisePier = new Pier(Type.MAYONNAISE, tunnel);

        ArrayList<Pier> piers = new ArrayList<Pier>();
        piers.add(breadPier);
        piers.add(sausagePier);
        piers.add(mayonnaisePier);

        Storage sausageStorage = new Storage(Type.SAUSAGE);
        Storage breadStorage = new Storage(Type.BREAD);
        Storage mayonnaiseStorage = new Storage(Type.MAYONNAISE);

        ArrayList<Storage> storage = new ArrayList<Storage>();
        storage.add(sausageStorage);
        storage.add(mayonnaiseStorage);
        storage.add(breadStorage);

        Home home = new Home(storage, piers);

        Hobo hobo1 = new Hobo(storage, home);
        Hobo hobo2 = new Hobo(storage, home);
        Hobo hobo3 = new Hobo(storage, home);
        Hobo hobo4 = new Hobo(storage, home);
        Hobo hobo5 = new Hobo(storage, home);
        Hobo hobo6 = new Hobo(storage, home);
        Hobo hobo7 = new Hobo(storage, home);
        Hobo hobo8 = new Hobo(storage, home);

        generator.start();
        breadPier.start();
        sausagePier.start();
        mayonnaisePier.start();
        hobo1.start();
        hobo2.start();
        hobo3.start();
        hobo4.start();
        hobo5.start();
        hobo6.start();
        hobo7.start();
        hobo8.start();

    }
}
