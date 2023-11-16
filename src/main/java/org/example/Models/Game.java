package org.example.Models;

import org.example.Strategies.WinningStrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private Player winner;
    private List<Move> moves;
    private GameState gameState;
    private List<WinningStrategy> winningStrategies;
    private int nextPlayerIndex;

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    private Game(int size, List<Player> players, List<WinningStrategy> winningStrategies) {
        this.board = new Board(size);
        this.players = players;
        this.moves = new ArrayList<>();
        this.gameState = GameState.IN_PROGRESS;
        this.winningStrategies=winningStrategies;
        this.nextPlayerIndex=0;
    }


    public static Builder getBuilder(){
        return new Builder();
    }
    public static class Builder{
        private List<WinningStrategy> winningStrategies;
        private List<Player> players;
        private int size;

        private Builder(){
            this.players=new ArrayList<>();
            this.winningStrategies=new ArrayList<>();
            this.size=0;
        }
        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setSize(int size) {
            this.size = size;
            return this;
        }

        private boolean validate(){
            // Only one bot
            // No 2 players should have same symbol
            return true;
        }
        public Game build() throws Exception {
            if(!validate()){
                throw new Exception("Validation Failed");
            }
            return new Game(size,players,winningStrategies);
        }
    }
    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public void undo(){

    }

    private boolean validateMove(Move move){
        int row=move.getCell().getRow();
        int col=move.getCell().getCol();
        return row >= 0 && row < board.getSize() && col >= 0 && col < board.getSize() &&
                board.getBoard().get(row).get(col).getCellstate().equals(CellState.EMPTY);
    }
    public void makeMove(Board board){
        Player currentPlayer=players.get(nextPlayerIndex);
        System.out.println("It is "+currentPlayer.getName()+"'s move");
        Move move=currentPlayer.makeMove(board);
        System.out.println(currentPlayer.getName()
                +" has moved at ,row:"+move.getCell().getRow()
                +", col:"+move.getCell().getCol());

        // validate move before we apply it to board
        if(!validateMove(move)){
            System.out.println("Invalid move by player : " + currentPlayer.getName());
            return;
        }
        int row=move.getCell().getRow();
        int col=move.getCell().getCol();
        Cell finalCellToMakeMove=board.getBoard().get(row).get(col);
        finalCellToMakeMove.setCellstate(CellState.FILLED);
        finalCellToMakeMove.setPlayer(currentPlayer);

        Move finalMove=new Move(currentPlayer,finalCellToMakeMove);
        moves.add(finalMove);

        nextPlayerIndex+=1;
        nextPlayerIndex%=players.size();

        // once a player has made the move check winner
        // check winner
        if(checkWinner(board,move)){
            gameState=GameState.ENDED;
            winner=currentPlayer;
        }
        else if(moves.size()==board.getSize()* board.getSize()){
            gameState=GameState.DRAW;
        }
    }

    private boolean checkWinner(Board board,Move move){
        for(WinningStrategy winningStrategy:winningStrategies){
            if(winningStrategy.checkWinner(board, move)) {
                return true;
            }
        }
        return false;
    }

    public void displayBoard(){
        board.displayBoard();
    }
}
