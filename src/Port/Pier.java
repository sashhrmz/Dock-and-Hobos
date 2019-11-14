package Port;

import ships.Ship;

public class Pier extends Thread {
    private Tunnel tunnel;
    Ship ship;

    @Override
    public void run() {
        ship = tunnel.get();
        System.out.println("The " + ship.getSize().toString() + " " + ship.getType().toString() +
                " ship swam to the pier.");
    }

}
