package org.example.Strategies.WinningStrategies;

import org.example.Models.Board;
import org.example.Models.Move;
import org.example.Models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class ColWinningStrategy implements WinningStrategy{
    private Map<Integer, Map<Symbol,Integer>> colMaps =new HashMap<>();
    @Override
    public boolean checkWinner(Board board, Move move) {
        int col=move.getCell().getCol();
        Symbol symbol=move.getPlayer().getSymbol();

        if(!colMaps.containsKey(col)){
            colMaps.put(col,new HashMap<>());
        }

        Map<Symbol,Integer> currColMap= colMaps.get(col);
        if(currColMap.containsKey(symbol)){
            currColMap.put(symbol,currColMap.get(symbol)+1);
        }
        else{
            currColMap.put(symbol,1);
        }
        return currColMap.get(symbol)==board.getSize();
    }
}
