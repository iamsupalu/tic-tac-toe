package org.example.Strategies.BotPlayingStrategies;

import org.example.Models.Board;
import org.example.Models.Move;

public interface BotPlayingStrategy {
    Move makeNextMove(Board board);
}
