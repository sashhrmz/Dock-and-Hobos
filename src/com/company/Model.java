package com.company;

import Hobos.*;
import Port.*;
import ships.*;

import java.util.ArrayList;
import java.util.List;

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

        Home home = new Home();

        Hobo hobo1 = new Hobo(piers, home);
        Hobo hobo2 = new Hobo(piers, home);
        Hobo hobo3 = new Hobo(piers, home);
        Hobo hobo5 = new Hobo(piers, home);
        Hobo hobo4 = new Hobo(piers, home);
        Hobo hobo6 = new Hobo(piers, home);
        Hobo hobo7 = new Hobo(piers, home);
        Hobo hobo8 = new Hobo(piers, home);
        ArrayList<Hobo> hobos = new ArrayList<Hobo>(List.of(hobo1, hobo2, hobo3, hobo4, hobo5, hobo6, hobo7, hobo8));

        home.setHobos(hobos);

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
