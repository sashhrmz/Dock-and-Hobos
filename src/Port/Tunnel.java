package Port;

import ships.Ship;
import ships.Size;
import ships.Type;

import java.util.ArrayList;

public class Tunnel {
    private volatile ArrayList<Ship> currentShips;
    private final Integer maxCountOfShips = 5;
    private volatile Integer countOfShips;

    public Tunnel() {
        currentShips = new ArrayList<Ship>();
        currentShips.add(new Ship(Type.BREAD, Size.MEDIUM));
        currentShips.add(new Ship(Type.MAYONNAISE, Size.MEDIUM));
        currentShips.add(new Ship(Type.SAUSAGE, Size.MEDIUM));
        countOfShips = 3;
    }

    synchronized void add(Ship ship) {
        if(countOfShips >= maxCountOfShips) System.out.println("The tunnel is full. The ship is drowned.");
        else {
            currentShips.add(ship);
            ++countOfShips;
        }
    }

    synchronized Ship get(int index) throws MyException {
        if(countOfShips.equals(0)) {
            throw new MyException("There is no ships in tunnel");
        }
        Ship ship = currentShips.get(index);
        currentShips.remove(index);
        --countOfShips;
        return ship;
    }

    public ArrayList<Ship> getShips() { return currentShips; }

}
