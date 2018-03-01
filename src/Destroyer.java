public class Destroyer extends Ship {
    public Destroyer(Coordinate coordinate1, Coordinate coordinate2){
        setSize(getShipTypeSize(ShipType.DESTROYER));
        setShipCoordinates(coordinate1, coordinate2);
        setShipType(ShipType.DESTROYER);
    }
}
