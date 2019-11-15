package com.company;

import Port.Generator;
import Port.Pier;
import Port.Tunnel;

public class Model {

    public static void main(String[] args) {
        Tunnel tunnel = new Tunnel();
        Generator generator = new Generator(tunnel);
        Pier pier = new Pier(tunnel);
        generator.start();
        pier.start();
    }
}
