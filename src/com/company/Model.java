package com.company;

import Port.Generator;
import Port.Pier;
import Port.Tunnel;
import ships.Type;

public class Model {

    public static void main(String[] args) {
        Tunnel tunnel = new Tunnel();
        Generator generator = new Generator(tunnel);
        Pier breadPier = new Pier(Type.BREAD, tunnel);
        Pier sausagePier = new Pier(Type.SAUSAGE, tunnel);
        Pier mayonnaisePier = new Pier(Type.MAYONNAISE, tunnel);
        generator.start();
        breadPier.start();
        sausagePier.start();
        mayonnaisePier.start();
    }
}
