package org.example.Strategies.WinningStrategies;

import org.example.Models.Board;
import org.example.Models.Move;
import org.example.Models.Player;

public interface WinningStrategy {
    Player checkWinner(Board board, Move move);
}
