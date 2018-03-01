public class Cruiser extends Ship {
    public Cruiser(Coordinate coordinate1, Coordinate coordinate2, Coordinate coordinate3){
        setSize(getShipTypeSize(ShipType.CRUISER));
        setShipCoordinates(coordinate1, coordinate2, coordinate3);
        setShipType(ShipType.CRUISER);
    }
}
