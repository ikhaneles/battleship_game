import javax.naming.directory.InvalidAttributeValueException;
import java.util.*;

public class Player {
    String[] shipNames = new String[]{"Submarine1", "Submarine2", "Destroyer1", "Destroyer2",
            "Cruiser", "Battleship", "Carrier"};
    private String playerName;
    private HashMap<String,Ship> fleet = new HashMap<>();
    private List<AttackCoordinate> strikedCoordinates = new ArrayList<AttackCoordinate>();

    Player(String name){
        playerName = name;
    }

    public String getPlayerName(){
        return playerName;
    }

    public void addShip(String shipName, ShipType shipType, Coordinate ...coordinates){
        if (ShipFactory.getInstance().coordinatesAreValid(shipType,coordinates) && !fleetHasCoordinates(coordinates)) {
            try {
            fleet.put(shipName,ShipFactory.getInstance().getShip(shipType, coordinates));
            }catch(InvalidAttributeValueException m){System.out.println(m);}
        }
        else {System.out.println("Coordinates of ship are not valid, ship was not placed.");}
    }


    public boolean fleetHasCoordinates(Coordinate ...coordinates){
        for (String shipName:shipNames){
            if (fleet.containsKey(shipName)){
                for (Coordinate coordinate:coordinates){
                    if (fleet.get(shipName).hasCoordinate(coordinate)){
                        return true;
                    }

                }
            }
        }
        return false;
    }

    public void printStrikedCoordinates(){
        for (AttackCoordinate attackCoordinate:strikedCoordinates){
            attackCoordinate.printCoordinate();
            if (attackCoordinate.getIsHit() == true){
                System.out.println(" was a HIT.");
            }
            else {
                System.out.println(" was a MISS.");
            }
        }
    }

    public void addStrikedCoordinate(AttackCoordinate attackCoordinate){
        strikedCoordinates.add(attackCoordinate);
    }

    public void damageFleet(AttackCoordinate attackCoordinate){
        for (String shipName:shipNames){
            if (fleet.containsKey(shipName)){
                if (fleet.get(shipName).hasCoordinate(attackCoordinate)){
                    fleet.get(shipName).takeDamage(attackCoordinate);
                }
            }
        }
    }

    public boolean allShipsPlaced(){
        if (fleet.containsKey("Submarine1") && fleet.containsKey("Submarine2") && fleet.containsKey("Destroyer1")
                && fleet.containsKey("Destroyer2") && fleet.containsKey("Cruiser") && fleet.containsKey("Battleship")
                && fleet.containsKey("Carrier")){
            return true;
        }
        else {return false;}
    }
    public void printFleet(){
        for (String shipName:shipNames){
            if (fleet.containsKey(shipName)){
                System.out.println("\n" +shipName+":");
                fleet.get(shipName).printShipCoordinates();
            }
        }
    }
    public boolean fleetNotSunk(){
        for (String shipName:shipNames){
            if (fleet.containsKey(shipName)){
                if (fleet.get(shipName).isAlive()){
                    return true;
                }
            }
        }
        return false;
    }

    public void attackOtherPlayer(AttackCoordinate attackCoordinate){

    }

    public void makeFleet(){
        Scanner input = new Scanner( System.in );
        while (this.allShipsPlaced() != true){
            System.out.println("Please select number ship to build/replace: \n" +
                    "Submarine1: 1\n" +
                    "Submarine2: 2\n" +
                    "Destroyer1: 3\n" +
                    "Destroyer2: 4\n" +
                    "Cruiser:    5\n" +
                    "Battleship: 6\n" +
                    "Carrier:    7\n");
            int shipNumber = input.nextInt();
            if (shipNumber>7 || shipNumber < 1){
                System.out.println("Please enter a valid ship number.");
            }
            else {
                switch (shipNumber) {
                    case (1):
                        System.out.println("Please enter row..");
                        int r1 = input.nextInt();
                        System.out.println("Please enter column..");
                        int c1 = input.nextInt();
                        Coordinate coordinate1 = new Coordinate(r1, c1);
                        addShip("Submarine1", ShipType.SUBMARINE, coordinate1);
                        break;
                    case (2):
                        System.out.println("Please enter row..");
                        r1 = input.nextInt();
                        System.out.println("Please enter column..");
                        c1 = input.nextInt();
                        coordinate1 = new Coordinate(r1, c1);
                        addShip("Submarine2", ShipType.SUBMARINE, coordinate1);
                        break;
                    case (3):
                        System.out.println("Please enter row..");
                        r1 = input.nextInt();
                        System.out.println("Please enter column..");
                        c1 = input.nextInt();
                        System.out.println("Please enter row..");
                        int r2 = input.nextInt();
                        System.out.println("Please enter column..");
                        int c2 = input.nextInt();
                        coordinate1 = new Coordinate(r1, c1);
                        Coordinate coordinate2 = new Coordinate(r2, c2);
                        addShip("Destroyer1", ShipType.DESTROYER, coordinate1, coordinate2);
                        break;
                    case (4):
                        System.out.println("Please enter row..");
                        r1 = input.nextInt();
                        System.out.println("Please enter column..");
                        c1 = input.nextInt();
                        System.out.println("Please enter row..");
                        r2 = input.nextInt();
                        System.out.println("Please enter column..");
                        c2 = input.nextInt();
                        coordinate1 = new Coordinate(r1, c1);
                        coordinate2 = new Coordinate(r2, c2);
                        addShip("Destroyer2", ShipType.DESTROYER, coordinate1, coordinate2);
                        break;
                    case (5):
                        System.out.println("Please enter row..");
                        r1 = input.nextInt();
                        System.out.println("Please enter column..");
                        c1 = input.nextInt();
                        System.out.println("Please enter row..");
                        r2 = input.nextInt();
                        System.out.println("Please enter column..");
                        c2 = input.nextInt();
                        System.out.println("Please enter row..");
                        int r3 = input.nextInt();
                        System.out.println("Please enter column..");
                        int c3 = input.nextInt();
                        coordinate1 = new Coordinate(r1, c1);
                        coordinate2 = new Coordinate(r2, c2);
                        Coordinate coordinate3 = new Coordinate(r3, c3);
                        addShip("Cruiser", ShipType.CRUISER, coordinate1, coordinate2, coordinate3);
                        break;
                    case (6):
                        System.out.println("Please enter row..");
                        r1 = input.nextInt();
                        System.out.println("Please enter column..");
                        c1 = input.nextInt();
                        System.out.println("Please enter row..");
                        r2 = input.nextInt();
                        System.out.println("Please enter column..");
                        c2 = input.nextInt();
                        System.out.println("Please enter row..");
                        r3 = input.nextInt();
                        System.out.println("Please enter column..");
                        c3 = input.nextInt();
                        System.out.println("Please enter row..");
                        int r4 = input.nextInt();
                        System.out.println("Please enter column..");
                        int c4 = input.nextInt();
                        coordinate1 = new Coordinate(r1, c1);
                        coordinate2 = new Coordinate(r2, c2);
                        coordinate3 = new Coordinate(r3, c3);
                        Coordinate coordinate4 = new Coordinate(r4, c4);
                        addShip("Battleship", ShipType.BATTLESHIP, coordinate1, coordinate2, coordinate3, coordinate4);
                        break;
                    case (7):
                        System.out.println("Please enter row..");
                        r1 = input.nextInt();
                        System.out.println("Please enter column..");
                        c1 = input.nextInt();
                        System.out.println("Please enter row..");
                        r2 = input.nextInt();
                        System.out.println("Please enter column..");
                        c2 = input.nextInt();
                        System.out.println("Please enter row..");
                        r3 = input.nextInt();
                        System.out.println("Please enter column..");
                        c3 = input.nextInt();
                        System.out.println("Please enter row..");
                        r4 = input.nextInt();
                        System.out.println("Please enter column..");
                        c4 = input.nextInt();
                        System.out.println("Please enter row..");
                        int r5 = input.nextInt();
                        System.out.println("Please enter column..");
                        int c5 = input.nextInt();
                        coordinate1 = new Coordinate(r1, c1);
                        coordinate2 = new Coordinate(r2, c2);
                        coordinate3 = new Coordinate(r3, c3);
                        coordinate4 = new Coordinate(r4, c4);
                        Coordinate coordinate5 = new Coordinate(r5, c5);
                        addShip("Carrier", ShipType.CARRIER, coordinate1, coordinate2, coordinate3, coordinate4, coordinate5);
                        break;
                }
                printFleet();
            }

        }
    }
    public void makeTestFleet(){
        Coordinate coordinate1 = new Coordinate(1,1);
        Coordinate coordinate2 = new Coordinate(1,2);
        Coordinate coordinate3 = new Coordinate(1,3);
        Coordinate coordinate4 = new Coordinate(1,4);
        addShip("Battleship", ShipType.BATTLESHIP, coordinate1, coordinate2, coordinate3, coordinate4);

        Coordinate coordinate5 = new Coordinate(6,4);
        addShip("Submarine1", ShipType.SUBMARINE, coordinate5);
    }
}
