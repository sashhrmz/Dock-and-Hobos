package com.company;

import Port.Generator;
import Port.Pier;
import Port.Tunnel;
import ships.Type;

public class Model {

    public static void main(String[] args) {
        Tunnel tunnel = new Tunnel();
        Generator generator = new Generator(tunnel);
        Pier firstPier = new Pier(Type.BREAD, tunnel);
        Pier secondPier = new Pier(Type.SAUSAGE, tunnel);
        Pier thirdPier = new Pier(Type.MAYONNAISE, tunnel);
        generator.start();
        firstPier.start();
        secondPier.start();
        thirdPier.start();
    }
}
