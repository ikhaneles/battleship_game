public class Submarine extends Ship {

    public Submarine(Coordinate coordinate1){
        setSize(getShipTypeSize(ShipType.SUBMARINE));
        setShipCoordinates(coordinate1);
        setShipType(ShipType.SUBMARINE);
    }

}
