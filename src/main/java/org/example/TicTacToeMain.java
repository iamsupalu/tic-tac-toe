package org.example;

import org.example.Controllers.GameController;
import org.example.Models.*;
import org.example.Strategies.BotPlayingStrategies.BotPlayingStrategy;
import org.example.Strategies.BotPlayingStrategies.EasyBotPlayingStrategy;
import org.example.Strategies.WinningStrategies.ColWinningStrategy;
import org.example.Strategies.WinningStrategies.DiaWinningStrategy;
import org.example.Strategies.WinningStrategies.RowWinningStrategy;
import org.example.Strategies.WinningStrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class TicTacToeMain {
    public static void main(String[] args) throws Exception {
        GameController gameController=new GameController();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter board size");
        int size=3;
        int noOfPlayers=size-1;

        List<Player> players=new ArrayList<>();
        players.add(new Player(1,new Symbol('X'),"Kumar", PlayerType.HUMAN));
        players.add(new Bot(2,"Bot",new Symbol('O'),PlayerType.BOT,
                BotDifficultyLevel.EASY,new EasyBotPlayingStrategy()));

        List<WinningStrategy> winningStrategies =new ArrayList<>();
        winningStrategies.add(new RowWinningStrategy());
        winningStrategies.add(new ColWinningStrategy());
        winningStrategies.add(new DiaWinningStrategy());

        //start the game
        Game game=gameController.startGame(size,players,winningStrategies);

        //start playing the game
        while(gameController.getGameStatus(game)== GameState.IN_PROGRESS){
            //Display the board
            System.out.println("This is current state of board");
            gameController.displayBoard(game);
            gameController.makeMove(game);
        }

        if(gameController.getGameStatus(game)==GameState.ENDED){
            System.out.println(gameController.getWinner(game).getName()+" has won the game");
        }

        else{
            System.out.println("Game Draw");
        }
    }
}