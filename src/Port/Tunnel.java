package Port;

import ships.Ship;
import java.util.ArrayList;

public class Tunnel {
    private volatile ArrayList<Ship> currentShips;
    private final Integer maxCountOfShips = 5;
    private final Integer minCountOfShips = 0;
    private Integer countOfShips;

    public Tunnel() {
        currentShips = new ArrayList<Ship>();
        countOfShips = 0;
    }

    public void add(Ship ship) {
        if(countOfShips >= maxCountOfShips) System.out.println("The tunnel is full. The ship is drowned.");
        else {
            currentShips.add(ship);
            ++countOfShips;
        }
    }

    public Ship get() {
        System.out.println(currentShips.size());
        Ship ship = currentShips.get(0);
        currentShips.remove(0);
        --countOfShips;
        return ship;
    }

}
