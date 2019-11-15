package Port;

import ships.Ship;

public class Pier extends Thread {
    private Tunnel tunnel;
    Ship ship;

    public Pier(Tunnel tunnel) { this.tunnel = tunnel; }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            ship = tunnel.get();
            System.out.println("The " + ship.getSize().toString() + " " + ship.getType().toString() +
                    " ship swam to the pier.");

            while (ship.getCount() > 0) {
                ship.unloadProduct(5);
                System.out.println("Five elements of " + ship.getType().toString() +
                        " is unloaded. There is " + ship.getCount().toString() + " out of "
                        + ship.getSize().toString() + " left to unload.");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        }
    }

}
