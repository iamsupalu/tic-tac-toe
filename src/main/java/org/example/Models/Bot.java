package org.example.Models;

import org.example.Strategies.BotPlayingStrategies.BotPlayingStrategy;

public class Bot extends Player{
    BotDifficultyLevel botDifficultyLevel;
    BotPlayingStrategy botPlayingStrategy;

    public Bot(int id, String name, Symbol symbol, PlayerType playerType, BotDifficultyLevel botDifficultyLevel,
               BotPlayingStrategy botPlayingStrategy){
        super(id,symbol,name,playerType);
        this.botDifficultyLevel=botDifficultyLevel;
        this.botPlayingStrategy=botPlayingStrategy;
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }
}
