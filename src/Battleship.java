public class Battleship extends Ship {
    public Battleship(Coordinate coordinate1, Coordinate coordinate2, Coordinate coordinate3, Coordinate coordinate4){
        setSize(getShipTypeSize(ShipType.BATTLESHIP));
        setShipCoordinates(coordinate1, coordinate2, coordinate3, coordinate4);
        setShipType(ShipType.BATTLESHIP);
    }
}
