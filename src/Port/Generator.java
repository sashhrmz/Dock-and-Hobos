package Port;

import ships.Ship;
import ships.Size;
import ships.Type;

import java.util.Random;

public class Generator extends Thread {
    private Tunnel tunnel;

    public Generator(Tunnel tunnel) {
        this.tunnel = tunnel;
    }

    @Override
    public void run() {
        while(true) {
            Type type = generateType();
            Size size = generateSize();
            Ship ship = new Ship(type, size);
            tunnel.add(ship);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Type generateType() {
        Random random = new Random();
        return Type.values()[random.nextInt(Type.values().length)];
    }

    private Size generateSize() {
        Random random = new Random();
        return Size.values()[random.nextInt(Type.values().length)];
    }
}
