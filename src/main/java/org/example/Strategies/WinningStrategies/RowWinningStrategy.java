package org.example.Strategies.WinningStrategies;

import org.example.Models.Board;
import org.example.Models.Move;
import org.example.Models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategy{
    private Map<Integer, Map<Symbol,Integer>> rowMaps=new HashMap<>();


    @Override
    public boolean checkWinner(Board board, Move move) {
        int row=move.getCell().getRow();
        Symbol symbol=move.getPlayer().getSymbol();

        if(!rowMaps.containsKey(row)){
            rowMaps.put(row,new HashMap<>());
        }

        Map<Symbol,Integer> currRowMap=rowMaps.get(row);
        if(currRowMap.containsKey(symbol)){
            currRowMap.put(symbol,currRowMap.get(symbol)+1);
        }
        else{
            currRowMap.put(symbol,1);
        }
        return currRowMap.get(symbol)==board.getSize();
    }
}
