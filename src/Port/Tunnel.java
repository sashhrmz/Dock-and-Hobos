package Port;

import ships.Ship;
import java.util.ArrayList;

public class Tunnel {
    private ArrayList<Ship> currentShips;
    private final Integer maxCountOfShips = 5;
    private final Integer minCountOfShips = 0;
    private Integer countOfShips;

    public Tunnel() {
        currentShips = new ArrayList<Ship>();
        countOfShips = 0;
    }

    public void add(Ship ship) {
        if(countOfShips.equals(maxCountOfShips)) System.out.println("The tunnel is full. The ship is drowned.");
        else currentShips.add(ship);
    }

    public Ship get() {
        Ship ship = currentShips.get(0);
        currentShips.remove(0);
        --countOfShips;
        return ship;
    }

}
