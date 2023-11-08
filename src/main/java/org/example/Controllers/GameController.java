package org.example.Controllers;

import org.example.Models.Game;
import org.example.Models.Player;
import org.example.Strategies.WinningStrategies.WinningStrategy;

import java.util.List;

public class GameController {
    public Game startGame(int size, List<Player> players, List<WinningStrategy> winningStrategies){
        return null;
    }
    public void displayBoard(Game game){
        game.displayBoard();
    }
    Player checkWinner(Game game){
        return game.getWinner();
    }
    public void makeMove(Game game){
        game.makeMove();
    }
    public void undo(Game game){
        game.undo();
    }
}
