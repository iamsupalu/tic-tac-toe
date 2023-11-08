package org.example.Models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private List<List<Cell>> board;

    public Board(int size) {
        this.size = size;
        board=new ArrayList<>();
        for(int i=0;i<size;i++){
            board.add(new ArrayList<>());
            for(int j=0;j<size;j++){
                board.get(i).add(new Cell(i,j));
            }
        }
    }

    public void displayBoard(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                Cell cell=board.get(i).get(j);
                if(cell.getCellstate().equals(CellState.EMPTY)){
                    System.out.println("|  |");
                }
                else{
                    System.out.println("|"+ cell.getPlayer().getSymbol()+"|");
                }
            }
            System.out.println();
        }
    }
}