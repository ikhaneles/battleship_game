//HAVE NOT YET STARTED WORKING ON THIS CLASS

import java.util.Random;


//public class AutomatedPlayer {
////public class AutomatedPlayer extends Player {
//    public void makeFleet() {
//        while (this.allShipsPlaced() != true) {
//            System.out.println("Please select number ship to build/replace: \n" +
//                    "Submarine1: 1\n" +
//                    "Submarine2: 2\n" +
//                    "Destroyer1: 3\n" +
//                    "Destroyer2: 4\n" +
//                    "Cruiser:    5\n" +
//                    "Battleship: 6\n" +
//                    "Carrier:    7\n");
//            int shipNumber = input.nextInt();
//            if (shipNumber > 7 || shipNumber < 1) {
//                System.out.println("Please enter a valid ship number.");
//            } else {
//                switch (shipNumber) {
//                    case (1):
//                        System.out.println("Please enter row..");
//                        int r1 = input.nextInt();
//                        System.out.println("Please enter column..");
//                        int c1 = input.nextInt();
//                        Coordinate coordinate1 = new Coordinate(r1, c1);
//                        addShip("Submarine1", ShipType.SUBMARINE, coordinate1);
//                        break;
//                    case (2):
//                        System.out.println("Please enter row..");
//                        r1 = input.nextInt();
//                        System.out.println("Please enter column..");
//                        c1 = input.nextInt();
//                        coordinate1 = new Coordinate(r1, c1);
//                        addShip("Submarine2", ShipType.SUBMARINE, coordinate1);
//                        break;
//                    case (3):
//                        System.out.println("Please enter row..");
//                        r1 = input.nextInt();
//                        System.out.println("Please enter column..");
//                        c1 = input.nextInt();
//                        System.out.println("Please enter row..");
//                        int r2 = input.nextInt();
//                        System.out.println("Please enter column..");
//                        int c2 = input.nextInt();
//                        coordinate1 = new Coordinate(r1, c1);
//                        Coordinate coordinate2 = new Coordinate(r2, c2);
//                        addShip("Destroyer1", ShipType.DESTROYER, coordinate1, coordinate2);
//                        break;
//                    case (4):
//                        System.out.println("Please enter row..");
//                        r1 = input.nextInt();
//                        System.out.println("Please enter column..");
//                        c1 = input.nextInt();
//                        System.out.println("Please enter row..");
//                        r2 = input.nextInt();
//                        System.out.println("Please enter column..");
//                        c2 = input.nextInt();
//                        coordinate1 = new Coordinate(r1, c1);
//                        coordinate2 = new Coordinate(r2, c2);
//                        addShip("Destroyer2", ShipType.DESTROYER, coordinate1, coordinate2);
//                        break;
//                    case (5):
//                        System.out.println("Please enter row..");
//                        r1 = input.nextInt();
//                        System.out.println("Please enter column..");
//                        c1 = input.nextInt();
//                        System.out.println("Please enter row..");
//                        r2 = input.nextInt();
//                        System.out.println("Please enter column..");
//                        c2 = input.nextInt();
//                        System.out.println("Please enter row..");
//                        int r3 = input.nextInt();
//                        System.out.println("Please enter column..");
//                        int c3 = input.nextInt();
//                        coordinate1 = new Coordinate(r1, c1);
//                        coordinate2 = new Coordinate(r2, c2);
//                        Coordinate coordinate3 = new Coordinate(r3, c3);
//                        addShip("Cruiser", ShipType.CRUISER, coordinate1, coordinate2, coordinate3);
//                        break;
//                    case (6):
//                        System.out.println("Please enter row..");
//                        r1 = input.nextInt();
//                        System.out.println("Please enter column..");
//                        c1 = input.nextInt();
//                        System.out.println("Please enter row..");
//                        r2 = input.nextInt();
//                        System.out.println("Please enter column..");
//                        c2 = input.nextInt();
//                        System.out.println("Please enter row..");
//                        r3 = input.nextInt();
//                        System.out.println("Please enter column..");
//                        c3 = input.nextInt();
//                        System.out.println("Please enter row..");
//                        int r4 = input.nextInt();
//                        System.out.println("Please enter column..");
//                        int c4 = input.nextInt();
//                        coordinate1 = new Coordinate(r1, c1);
//                        coordinate2 = new Coordinate(r2, c2);
//                        coordinate3 = new Coordinate(r3, c3);
//                        Coordinate coordinate4 = new Coordinate(r4, c4);
//                        addShip("Battleship", ShipType.BATTLESHIP, coordinate1, coordinate2, coordinate3, coordinate4);
//                        break;
//                    case (7):
//                        System.out.println("Please enter row..");
//                        r1 = input.nextInt();
//                        System.out.println("Please enter column..");
//                        c1 = input.nextInt();
//                        System.out.println("Please enter row..");
//                        r2 = input.nextInt();
//                        System.out.println("Please enter column..");
//                        c2 = input.nextInt();
//                        System.out.println("Please enter row..");
//                        r3 = input.nextInt();
//                        System.out.println("Please enter column..");
//                        c3 = input.nextInt();
//                        System.out.println("Please enter row..");
//                        r4 = input.nextInt();
//                        System.out.println("Please enter column..");
//                        c4 = input.nextInt();
//                        System.out.println("Please enter row..");
//                        int r5 = input.nextInt();
//                        System.out.println("Please enter column..");
//                        int c5 = input.nextInt();
//                        coordinate1 = new Coordinate(r1, c1);
//                        coordinate2 = new Coordinate(r2, c2);
//                        coordinate3 = new Coordinate(r3, c3);
//                        coordinate4 = new Coordinate(r4, c4);
//                        Coordinate coordinate5 = new Coordinate(r5, c5);
//                        addShip("Carrier", ShipType.CARRIER, coordinate1, coordinate2, coordinate3, coordinate4, coordinate5);
//                        break;
//                }
//                printFleet();
//            }
//
//        }
//    }
//    public Coordinate getInitialComputerCoordinate(){
//        Random r = new Random();
//        int row = r.nextInt(10);
//        int col = r.nextInt(10);
//
//        Coordinate coordinate = new Coordinate(row, col);
//        return coordinate;
//    }
//
//    public Coordinate getOtherCoordinate(Coordinate firstCoordinate, ShipType shipType) {
//        Random r = new Random();
//        int directionCode = r.nextInt(4);
//        int size = Ship.getShipTypeSize(shipType);
//        int increment = size - 1;
//        int col = firstCoordinate.getCol();
//        int row = firstCoordinate.getRow();
//
//        switch (directionCode) {
//            case (0):
//                col = col + increment;
//                break;
//            case (1):
//                col = col - increment;
//                break;
//            case(2):
//                row = row + increment;
//                break;
//            case(3):
//                row = row - increment;
//                break;
//
//        }
//    }
//}
