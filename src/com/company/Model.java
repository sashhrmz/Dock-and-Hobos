package com.company;

import Port.Generator;
import Port.Pier;
import Port.Tunnel;

public class Model {

    public static void main(String[] args) {
        Tunnel tunnel = new Tunnel();
        Generator generator = new Generator(tunnel);
        Pier firstPier = new Pier(tunnel);
        Pier secondPier = new Pier(tunnel);
        Pier thirdPier = new Pier(tunnel);
        generator.start();
        firstPier.start();
        secondPier.start();
        thirdPier.start();
    }
}
