import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myScannerObj = new Scanner(System.in);

        //Taking input of board size.
        System.out.println("Please enter the size of the board (int) : ");
        int boardSize = Integer.parseInt(myScannerObj.nextLine());

        System.out.println("Please enter the number of players want to play the game (int) : ");
        int numberOfPlayer = Integer.parseInt(myScannerObj.nextLine());
        List<String> playersName = new ArrayList<>();
        for (int i=0; i<numberOfPlayer; i++){
            System.out.println("Please enter the player name : (String) : ");
            playersName.add(myScannerObj.nextLine());
        }

        GameBoard gameBoardObj = new GameBoard(boardSize);
    }
}