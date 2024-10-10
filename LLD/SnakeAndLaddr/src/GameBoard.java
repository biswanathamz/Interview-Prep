import Game.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class GameBoard {
    private Dice dice;
    private Queue<Player> nextPlayer;
    private List<Jumper> snake;
    private List<Jumper> ladder;
    private Map<Integer,Integer> playerCurrentPosition;
    private int boardSze;

    public GameBoard(Dice dice, Queue<Player> nextPlayer, List<Jumper> snake, List<Jumper> ladder, Map<Integer,Integer> playerCurrentPosition, int boardSze){
        this.dice = dice;
        this.nextPlayer = nextPlayer;
        this.snake = snake;
        this.ladder = ladder;
        this.playerCurrentPosition =playerCurrentPosition;
        this.boardSze = boardSze;
    }

    void startGame(){
        List<String> playerRank = new ArrayList<>();
        while (nextPlayer.size()>1){
            Player player = nextPlayer.poll();
            int currentPosition = playerCurrentPosition.get(player.getPlayerId());
            int diceRollValue = dice.rollDice();
            System.out.println("-----------------------------------------------------------");
            System.out.println("Dice rolled by "+player.getPlayerName()+" and got : "+diceRollValue);
            int nextCell = currentPosition+diceRollValue;
            if(nextCell>boardSze){nextPlayer.offer(player);}
            else if (nextCell==boardSze){
                System.out.println(player.getPlayerName()+" Won the match");
                playerRank.add(player.getPlayerName());
            }else{
                snake.forEach(v->{
                    if(v.getStartPoint()==nextCell){
                        System.out.println(player.getPlayerName() + " Bitten by Snake present at: "+ nextCell);
                        playerCurrentPosition.put(player.getPlayerId(),v.getEndPoint());
                    }
                });

                AtomicInteger varNextCell = new AtomicInteger();
                AtomicBoolean ladderFlag = new AtomicBoolean(false);
                ladder.forEach(v->{
                    if(v.getStartPoint()==nextCell){
                        System.out.println(player.getPlayerName() + " Got ladder present at: "+ nextCell);
                        varNextCell.set(v.getEndPoint());
                        ladderFlag.set(true);
                        playerCurrentPosition.put(player.getPlayerId(),v.getEndPoint());
                    }
                });

                int currentCellValue;
                if(ladderFlag.get()){
                    currentCellValue = varNextCell.get();
                }else{
                    currentCellValue = nextCell;
                }

                if(currentCellValue==boardSze){
                    System.out.println(player.getPlayerName()+" Won the match");
                    playerRank.add(player.getPlayerName());
                }else{
                    System.out.println(player.getPlayerName() + " is at position "+ currentCellValue);
                    playerCurrentPosition.put(player.getPlayerId(),currentCellValue);
                    nextPlayer.offer(player);
                }
            }
        }
        System.out.println("-----------------------------------------------------------");
        System.out.println("-----------------------------------------------------------");
        for (int i=0; i<playerRank.size();i++){
            System.out.println("Player Name : "+playerRank.get(i)+" , Rank : "+(i+1));
        }
        System.out.println("-----------------------------------------------------------");
        Player player = nextPlayer.poll();
        System.out.println(player.getPlayerName()+" a is looser !");
        System.out.println("-----------------------------------------------------------");
        System.out.println("-----------------------------------------------------------");
    }
}
