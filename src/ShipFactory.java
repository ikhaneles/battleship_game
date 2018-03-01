import javax.naming.directory.InvalidAttributeValueException;
import java.io.IOException;

public class ShipFactory {

    private static ShipFactory shipFactoryInstance = null;

    public static ShipFactory getInstance(){
        if (shipFactoryInstance == null){
            shipFactoryInstance = new ShipFactory();
            return shipFactoryInstance;
        }
        else return shipFactoryInstance;
    }

    public Ship getShip(ShipType shipType, Coordinate ...coordinates) throws InvalidAttributeValueException{
        Ship ship;
        if (shipType == ShipType.SUBMARINE){
            ship = new Submarine(coordinates[0]);
        }
        else if (shipType == ShipType.DESTROYER){
            ship = new Destroyer(coordinates[0], coordinates[1]);
        }
        else if (shipType == ShipType.CRUISER){
            ship = new Cruiser(coordinates[0], coordinates[1], coordinates[2]);
        }

        else if (shipType == ShipType.BATTLESHIP){
            ship = new Battleship(coordinates[0], coordinates[1], coordinates[2], coordinates[3]);
        }
        else if (shipType == ShipType.CARRIER){
            ship = new Carrier(coordinates[0], coordinates[1], coordinates[2], coordinates[3], coordinates[4]);
        }
        else{
            throw new InvalidAttributeValueException();
        }
        return ship;
    }

    //consider placing these two methods somewhere else...
    public boolean coordinatesAreValid(ShipType shipType, Coordinate ...coordinates){
        int size = Ship.getShipTypeSize(shipType);
        boolean sameRow = sameRow(coordinates);
        boolean sameColumn = sameColumn(coordinates);
        if (outOfBounds(coordinates)){
            return false;
        }
        if (hasOverlaps(coordinates)){
            System.out.println("Coordinates have overlaps");
            return false;
        }
        if(sameColumn){
            if(maxRowValue(coordinates) - minRowValue(coordinates) == size - 1){
                return true;
            }
            else {return false;}
        }
        else if(sameRow){
            if(maxColumnValue(coordinates) - minColumnValue(coordinates) == size - 1){
                return true;
            }
            else {return false;}

        }
        else {return false;}
    }

    //checks how many of that ship a player has, this may not be necessary depending on what user interface allows player to do
//    public boolean shipIsAllowed(ShipType shipType){
//
//    }.

    private boolean sameRow(Coordinate ...coordinates){
        for (Coordinate coordinate:coordinates){
            if (coordinates[0].getRow()!= coordinate.getRow()){
                return false;
            }
        }
        return true;
    }
    private boolean sameColumn(Coordinate ...coordinates){
        for (Coordinate coordinate:coordinates){
            if (coordinates[0].getCol()!= coordinate.getCol()){
                return false;
            }
        }
        return true;
    }

    private int maxColumnValue(Coordinate ...coordinates){
        int temp = 0;//eventually have this not be hard coded in all max/mins
        for(Coordinate coordinate:coordinates){
            int currentColumn = coordinate.getCol();
            if (currentColumn > temp){
                temp = currentColumn;
            }
        }
        return temp;
    }

    private int maxRowValue(Coordinate ...coordinates){
        int temp = 0;//eventually have this not be hard coded in all max/mins
        for(Coordinate coordinate:coordinates){
            int currentRow = coordinate.getRow();
            if (currentRow > temp){
                temp = currentRow;
            }
        }
        return temp;
    }

    private int minColumnValue(Coordinate ...coordinates){
        int temp = 9;//eventually have this not be hard coded in all max/mins
        for(Coordinate coordinate:coordinates){
            int currentColumn = coordinate.getCol();
            if (currentColumn < temp){
                temp = currentColumn;
            }
        }
        return temp;
    }

    private int minRowValue(Coordinate ...coordinates){
        int temp = 9;//eventually have this not be hard coded in all max/mins
        for(Coordinate coordinate:coordinates){
            int currentRow = coordinate.getRow();
            if (currentRow < temp){
                temp = currentRow;
            }
        }
        return temp;
    }

    private boolean hasOverlaps(Coordinate ...coordinates){
        for(Coordinate coordinate1:coordinates){
            for(Coordinate coordinate2:coordinates){
                if(coordinate1.getCol() == coordinate2.getCol() && coordinate1.getRow() == coordinate2.getRow() && coordinate1 != coordinate2){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean outOfBounds(Coordinate ...coordinates){
        for (Coordinate coordinate:coordinates){
            if (coordinate.getRow() > 9 || coordinate.getRow() < 0){
                return true;
            }
            if (coordinate.getCol() > 9 || coordinate.getCol() < 0){
                return true;
            }
        }
        return false;
    }

}

