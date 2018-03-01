import java.util.*;

public abstract class Ship {

    private int size;
    private ShipType shipType;
    private boolean alive;
    private int damage;
    public boolean placed;
    private  List<Coordinate> shipCoordinates = new ArrayList<Coordinate>();
    private  List<Coordinate> damagedCoordinates = new ArrayList<Coordinate>();


    public Ship(){
        this.alive = true;
        this.placed = true;
        this.damage = 0;
    }

    int getSize(){
        return size;
    }
    void setSize(int s){
        size = s;
    }
    ShipType getShipType(){
        return shipType;
    }
    void setShipType(ShipType t){
        shipType = t;
    }
    public boolean isAlive(){
        return alive;
    }
    public void sinkShip(){
        this.alive = false;
    }




    /*
    Should take variable number of coordinates based on the ships size.
    */
    public void setShipCoordinates(Coordinate ...settingCoordinates){
        for (Coordinate coordinate:settingCoordinates){
            shipCoordinates.add(coordinate);
        }
    }

    public void setDamagedCoordinate(Coordinate damagedCoordinate){
        damagedCoordinates.add(damagedCoordinate);
    }



    /*
    Should take a single coordinate, check if that coordinate belongs to the ship and whether
    or not it is already damaged at that spot (if game allows striking same spot twice...)
    */
    public void takeDamage(AttackCoordinate attackCoordinate){
        if (this.hasCoordinate(attackCoordinate) && !this.hasDamagedCoordinate(attackCoordinate)){
            setDamagedCoordinate(attackCoordinate);
            damage++;
            if (size==damage) {
                this.sinkShip();
            }
        }
    }
    public static Integer getShipTypeSize(ShipType shipType){
       HashMap<ShipType,Integer> sizes = new HashMap<>();
       sizes.put(ShipType.SUBMARINE, 1);
       sizes.put(ShipType.DESTROYER, 2);
       sizes.put(ShipType.CRUISER, 3);
       sizes.put(ShipType.BATTLESHIP, 4);
       sizes.put(ShipType.CARRIER, 5);

       Integer size = sizes.get(shipType);
       return size;
    }

    public boolean hasCoordinate(Coordinate coordinate1){
        //return shipCoordinates.contains(coordinate);    //realized i cannot just do this...
        int c1 = coordinate1.getCol();
        int r1 = coordinate1.getRow();
        int c2;
        int r2;
        for(Coordinate coordinate2:shipCoordinates){
            c2 = coordinate2.getCol();
            r2 = coordinate2.getRow();
            if(c1 == c2 && r1 == r2){
                return true;
            }
        }
        return false;

    }

    private boolean hasDamagedCoordinate(AttackCoordinate coordinate1){
        //return shipCoordinates.contains(coordinate);    //realized i cannot just do this...
        int c1 = coordinate1.getCol();
        int r1 = coordinate1.getRow();
        int c2;
        int r2;
        for(Coordinate coordinate2:damagedCoordinates){
            c2 = coordinate2.getCol();
            r2 = coordinate2.getRow();
            if(c1 == c2 && r1 == r2){
                return true;
            }
        }
        return false;

    }

    public void printShipCoordinates(){
        for (Coordinate coordinate:shipCoordinates){
            coordinate.printCoordinate();
        }
    }

}
