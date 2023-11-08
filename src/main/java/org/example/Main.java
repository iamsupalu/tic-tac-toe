package org.example;

import org.example.Controllers.GameController;
import org.example.Models.Game;
import org.example.Models.Player;
import org.example.Strategies.WinningStrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        GameController gameController=new GameController();
        List<Player> players=new ArrayList<>();
        List<WinningStrategy> winningStrategies =new ArrayList<>();
        Game game=gameController.startGame(3,players,winningStrategies);
        gameController.makeMove(game);
    }
}