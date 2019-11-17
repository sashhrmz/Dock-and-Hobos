package Port;

import ships.Ship;
import ships.Type;

public class Pier extends Thread {
    private Type type;
    private Tunnel tunnel;
    private Ship ship;
    private boolean isThereShip;
    private volatile Integer count;

    public Pier(Type type, Tunnel tunnel) {
        this.tunnel = tunnel;
        this.type = type;
        this.isThereShip = false;
        count = 0;
    }

    public synchronized void get() { --count; }

    public Type getType() { return type; }

    public boolean checkToSteal() { return count > 0; }

    @Override
    public void run() {
        while(true) {
            for (int i = 0; i < tunnel.getShips().size(); ++i) {
                if (tunnel.getShips().get(i).getType() == type) {
                    try {
                        ship = tunnel.get(i);
                    } catch (MyException e) {
                        System.out.println(e.getMessage());
                    }
                    isThereShip = true;
                    break;
                }
            }
            if (isThereShip) {
                System.out.println("The " + ship.getSize().toString() + " " + ship.getType().toString() +
                        " ship swam to the pier.");

                while (ship.getCount() > 0) {
                    ship.unloadProduct(5);
                    count += 5;
                    System.out.println("Five elements of " + ship.getType().toString() +
                            " is unloaded. There is " + ship.getCount().toString() + " out of "
                            + ship.getSize().toString() + " left to unload. There is " + count.toString()
                            + " " + ship.getType() + " in the pier.");
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("The " + ship.getSize().toString() + " " + ship.getType().toString() + " ship left.");
                isThereShip = false;
            } else {
                System.out.println("No suitable ship in the tunnel");
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
