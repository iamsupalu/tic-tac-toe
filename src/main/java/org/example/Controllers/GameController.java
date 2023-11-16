package org.example.Controllers;

import org.example.Models.Game;
import org.example.Models.GameState;
import org.example.Models.Player;
import org.example.Strategies.WinningStrategies.WinningStrategy;

import java.util.List;

public class GameController {
    public Game startGame(int size, List<Player> players, List<WinningStrategy> winningStrategies) throws Exception {
        return Game.getBuilder()
                .setSize(size)
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .build();
    }
    public void displayBoard(Game game){
        game.displayBoard();
    }
    public Player getWinner(Game game){
        return game.getWinner();
    }
    public void makeMove(Game game){
        game.makeMove(game.getBoard());
    }
    public void undo(Game game){
        game.undo();
    }

    public GameState getGameStatus(Game game){return game.getGameState();}
}
