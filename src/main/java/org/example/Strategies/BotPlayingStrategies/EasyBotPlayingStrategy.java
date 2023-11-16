package org.example.Strategies.BotPlayingStrategies;

import org.example.Models.Board;
import org.example.Models.Cell;
import org.example.Models.CellState;
import org.example.Models.Move;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{

    @Override
    public Move makeMove(Board board) {
        for(List<Cell> row:board.getBoard()){
            for(Cell cell:row){
                if(cell.getCellstate().equals(CellState.EMPTY)){
                    //make move
                    return new Move(null,cell);
                }
            }
        }
        return null;
    }
}
