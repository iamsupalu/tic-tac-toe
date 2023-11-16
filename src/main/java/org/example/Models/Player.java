package org.example.Models;

import java.util.Scanner;

public class Player {
    private int id;
    private Symbol symbol;
    private String name;
    private PlayerType playerType;

    public Player(int id, Symbol symbol, String name, PlayerType playerType) {
        this.id = id;
        this.symbol = symbol;
        this.name = name;
        this.playerType = playerType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Move makeMove(Board board){
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter row index to make move");
        int rowIndex=sc.nextInt();
        System.out.println("Please enter col index to make move");
        int colIndex=sc.nextInt();
        return new Move(this, new Cell(rowIndex,colIndex));
    }
}
