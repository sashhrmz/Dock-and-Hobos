package Port;

import ships.Ship;
import ships.Size;
import ships.Type;

import java.util.ArrayList;

public class Tunnel {
    private volatile ArrayList<Ship> currentShips;
    private final Integer maxCountOfShips = 5;
    private final Integer minCountOfShips = 0;
    private volatile Integer countOfShips;

    public Tunnel() {
        currentShips = new ArrayList<Ship>();
        currentShips.add(new Ship(Type.BREAD, Size.MEDIUM));
        currentShips.add(new Ship(Type.MAYONNAISE, Size.MEDIUM));
        currentShips.add(new Ship(Type.SAUSAGE, Size.MEDIUM));
        countOfShips = 0;
    }

    synchronized void add(Ship ship) {
        if(countOfShips >= maxCountOfShips) System.out.println("The tunnel is full. The ship is drowned.");
        else {
            currentShips.add(ship);
            ++countOfShips;
        }
    }

    synchronized Ship get() {
        Ship ship = currentShips.get(0);
        currentShips.remove(0);
        --countOfShips;
        return ship;
    }

}
