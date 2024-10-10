import Game.*;

import java.util.*;
import java.util.concurrent.atomic.LongAdder;

public class Main {
    public static void main(String[] args) {
        Scanner myScannerObj = new Scanner(System.in);

        System.out.println("Please enter the size of a board (int) : ");
        int boardSize = Integer.parseInt(myScannerObj.nextLine());

        System.out.println("Please enter the number of dice (int) : ");
        int diceCount = Integer.parseInt(myScannerObj.nextLine());

        List<String> playerNames = new ArrayList<>();
        System.out.println("Please enter the number of players want to play the game (int) : ");
        int numberOfPlayer = Integer.parseInt(myScannerObj.nextLine());
        for (int i = 0; i<numberOfPlayer; i++){
            System.out.println("Please enter the player name : (String) : ");
            playerNames.add(myScannerObj.nextLine());
        }

        Dice dice = new Dice(diceCount);

        Queue<Player> playerList = new LinkedList<>();
        Map<Integer,Integer> playerCurrentPosition = new HashMap<>();
        for (int i = 0; i<numberOfPlayer; i++){
            Player player = new Player(i, playerNames.get(i));
            playerList.offer(player);
            playerCurrentPosition.put(i,0);
        }

        List<Jumper> ladderList = new ArrayList<>();
        Jumper ladder1 = new Jumper(3,30);
        Jumper ladder2 = new Jumper(10,22);
        Jumper ladder3 = new Jumper(40,80);
        ladderList.add(ladder1);
        ladderList.add(ladder2);
        ladderList.add(ladder3);

        List<Jumper> snakeList = new ArrayList<>();
        Jumper snake1 = new Jumper(32,5);
        Jumper snake2 = new Jumper(54,31);
        Jumper snake3 = new Jumper(72,32);
        snakeList.add(snake1);
        snakeList.add(snake2);
        snakeList.add(snake3);

        GameBoard gameBoard = new GameBoard(dice,playerList,snakeList, ladderList, playerCurrentPosition, boardSize);
        gameBoard.startGame();
    }
}