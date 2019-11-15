package Port;

import ships.Ship;
import ships.Type;

public class Pier extends Thread {
    private Type type;
    private Tunnel tunnel;
    private Ship ship;
    private boolean isThereShip;

    public Pier(Type type, Tunnel tunnel) {
        this.tunnel = tunnel;
        this.type = type;
        this.isThereShip = false;
    }

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
                    System.out.println("Five elements of " + ship.getType().toString() +
                            " is unloaded. There is " + ship.getCount().toString() + " out of "
                            + ship.getSize().toString() + " left to unload.");
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
