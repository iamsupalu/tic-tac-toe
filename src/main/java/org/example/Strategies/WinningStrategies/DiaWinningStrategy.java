package org.example.Strategies.WinningStrategies;

import org.example.Models.Board;
import org.example.Models.Move;
import org.example.Models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class DiaWinningStrategy implements WinningStrategy{
    private Map<Symbol,Integer> leftDiagonalMap=new HashMap<>();
    private Map<Symbol,Integer> rightDiagonalMap=new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {
        int row=move.getCell().getRow();
        int col=move.getCell().getCol();
        Symbol symbol=move.getPlayer().getSymbol();
        if(row==col){
            //cell is present on left diagonal
            if(leftDiagonalMap.containsKey(symbol)){
                leftDiagonalMap.put(symbol, leftDiagonalMap.get(symbol)+1);
            }
            else{
                leftDiagonalMap.put(symbol,1);
            }
        }

        if(row+col==board.getSize()-1){
            //cell is present on left diagonal
            if(rightDiagonalMap.containsKey(symbol)){
                rightDiagonalMap.put(symbol, rightDiagonalMap.get(symbol)+1);
            }
            else{
                rightDiagonalMap.put(symbol,1);
            }
        }

        if(row==col && leftDiagonalMap.get(symbol)== board.getSize()){
            return true;
        }
        if(row+col== board.getSize()-1 && rightDiagonalMap.get(symbol)== board.getSize()){
            return true;
        }
        return false;
    }
}
