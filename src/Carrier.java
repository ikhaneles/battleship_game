public class Carrier extends Ship {
    public Carrier(Coordinate coordinate1, Coordinate coordinate2, Coordinate coordinate3, Coordinate coordinate4, Coordinate coordinate5){
        setSize(getShipTypeSize(ShipType.CARRIER));
        setShipCoordinates(coordinate1, coordinate2, coordinate3, coordinate4, coordinate5);
        setShipType(ShipType.CARRIER);
    }
}
