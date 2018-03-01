import java.util.Scanner;

public class BattleshipGame {
    //these care currently unused, discussion on why below...
    private Player player1;
    private Player player2;

    //design question: should i keep all methods in this class as static, i.e. do i actually need to create a "BattleshipGame"
    //variables above can be deleted if i keep everything as static.
    //TODO consider making this class into a singleton (read up on singletons)...

    public static void main(String args[]){
        printArt();
        playGame();
    }

    public static void playGame(){

        Player player1 = new Player("Isaac");
        Player player2 = new Player("Jon");

// WILL USE THE BELOW FUNCTIONS FOR ACTUAL GAMEPLAY
        player1.makeFleet();
        player2.makeFleet();
//The below two functions are for testing gameplay
//        player1.makeTestFleet();
//        player2.makeTestFleet();

        while(player1.fleetNotSunk() && player2.fleetNotSunk()){
            playerTurn(player1, player2);
            playerTurn(player2, player1);

        }
        determineWinner(player1, player2);


    }


    private static void playerTurn(Player attackingPlayer, Player otherPlayer){
        Scanner input = new Scanner(System.in);
        System.out.println("\n\n\n" + attackingPlayer.getPlayerName() + ", it is your turn\nYour fleet is printed below.");
        attackingPlayer.printFleet();
        System.out.println("\n\nYour previous attacks are printed below.");
        attackingPlayer.printStrikedCoordinates();
        boolean validCoordinate = false;
        int row1 = 0;
        int col1 = 0;
        while (validCoordinate == false) {
            System.out.println(attackingPlayer.getPlayerName() + ", please enter the row for an attack coordinate..");
            row1 = input.nextInt();
            System.out.println(attackingPlayer.getPlayerName() + ", please enter the column for an attack coordinate..");
            col1 = input.nextInt();
            if (row1 <= 9 && row1 >=0 && col1 <= 9 && col1 >=0){
                validCoordinate = true;
            }
            else{System.out.println("Please enter a valid coordinate.");}
        }
        AttackCoordinate playerAttackCoordinate = new AttackCoordinate(row1, col1);

        //TODO consider putting this in the attackPlayer method in Player class!
        if(otherPlayer.fleetHasCoordinates(playerAttackCoordinate)){
            System.out.println("That's a hit!");
            playerAttackCoordinate.setIsHit(true);
            otherPlayer.damageFleet(playerAttackCoordinate);
        }
        else{
            System.out.println("That's a miss!");
            playerAttackCoordinate.setIsHit(false);
        }
        attackingPlayer.addStrikedCoordinate(playerAttackCoordinate);
    }


    private static void determineWinner(Player player1, Player player2){
        if(!player1.fleetNotSunk() && !player2.fleetNotSunk()){
            System.out.println("Both of your fleets are wiped out! It's a tie!");
        }
        else if (player1.fleetNotSunk() && !player2.fleetNotSunk()){
            System.out.println(player2.getPlayerName() + ", all your ships have been destroyed! " + player1.getPlayerName() + " wins!");
        }
        else if (!player1.fleetNotSunk() && player2.fleetNotSunk()){
            System.out.println(player1.getPlayerName() + ", all your ships have been destroyed! " + player2.getPlayerName() + " wins!");
        }
    }






    //I did not create this art, found it at http://ascii.co.uk/art/battleship
    private static void printArt(){
        System.out.println("______       _   _   _           _     _         _             _____                      \n" +
                "| ___ \\     | | | | | |         | |   (_)       | |           |_   _|                     \n" +
                "| |_/ / __ _| |_| |_| | ___  ___| |__  _ _ __   | |__  _   _    | | ___  __ _  __ _  ___  \n" +
                "| ___ \\/ _` | __| __| |/ _ \\/ __| '_ \\| | '_ \\  | '_ \\| | | |   | |/ __|/ _` |/ _` |/ __| \n" +
                "| |_/ / (_| | |_| |_| |  __/\\__ \\ | | | | |_) | | |_) | |_| |  _| |\\__ \\ (_| | (_| | (__  \n" +
                "\\____/ \\__,_|\\__|\\__|_|\\___||___/_| |_|_| .__/  |_.__/ \\__, |  \\___/___/\\__,_|\\__,_|\\___| \n" +
                "                                        | |             __/ |                             \n" +
                "                                        |_|            |___/  ");
        System.out.println("                                     |__\n" +
                "                                     |\\/\n" +
                "                                     ---\n" +
                "                                     / | [\n" +
                "                              !      | |||\n" +
                "                            _/|     _/|-++'\n" +
                "                        +  +--|    |--|--|_ |-\n" +
                "                     { /|__|  |/\\__|  |--- |||__/\n" +
                "                    +---------------___[}-_===_.'____                 /\\\n" +
                "                ____`-' ||___-{]_| _[}-  |     |_[___\\==--            \\/   _\n" +
                " __..._____--==/___]_|__|_____________________________[___\\==--____,------' .7\n" +
                "|                                                                     BB-61/\n" +
                " \\_________________________________________________________________________|");
        System.out.println("\nThe above art was made by Matthew Bace and was found at http://ascii.co.uk/art/battleship\n");
    }
}
