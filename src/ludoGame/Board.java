package ludoGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Board {
    private List<Square> squares;
    private HashMap<String, Square> startingSquares;
    private HashMap<String, List<Square>> finalLanes;

    public Board() {
        this.squares = new ArrayList<Square>();
        this.startingSquares = new HashMap<>();
        this.finalLanes = new HashMap<>();
        initialize();
    }

    public void initialize() {
        int totalSquares = 52;

        for (int i = 0; i < totalSquares; i++) {
            Square square = new Square( new Position( i / 13, i % 13 ), false);
            squares.add(square);
        }
        String[] colors = {"red", "green", "blue", "yellow"};
        setStartingSquares(colors);
        setFinalLanesForPlayers(colors);
    }


    private void setStartingSquares(String[] colors) {
        int[] startIndices = {0, 13, 26, 39};
        for (int i = 0; i < colors.length; i++) {
            String color = colors[i];
            int index = startIndices[i];
            Square startSquare = squares.get(index);
            startSquare.setSafe(true);
            startingSquares.put(color, startSquare);
        }
    }

    public int getSquareIndex(Square square) {
        return squares.indexOf(square);
    }


    private void setFinalLanesForPlayers(String[] colors) {
        for (String color : colors) {
            List<Square> finalSquares = new ArrayList<>();
            for (int i = 0; i < 6; i++) {
                Square square = new Square( new Position( -1, i ), true);
                finalSquares.add(square);
            }
            finalLanes.put(color, finalSquares);
        }
    }

    public Square getStartingSquareForPlayer(Player player) {
        return startingSquares.get(player.getColor().toLowerCase());
    }

    public Square getNextSquare(Square currentSquare, int steps) {
        int currentIndex = squares.indexOf(currentSquare);
        int nextIndex = (currentIndex + steps) % squares.size();
        return squares.get(nextIndex);
    }


    public boolean isReachedFinalSquare(Square square, Player player) {
        List<Square> lane = finalLanes.get(player.getColor().toLowerCase());
        return lane != null && !lane.isEmpty() && square.equals(lane.getLast());
    }


    public Square getNextFinalSquare(String color, Square currentSquare, int steps) {
        List<Square> lane = finalLanes.get(color.toLowerCase());
        int currentSquareIndex = lane.indexOf(currentSquare);
        int nextSquareIndex = currentSquareIndex + steps;
        if (nextSquareIndex >= lane.size()) {
            return lane.getLast();
        } else {
            return lane.get(nextSquareIndex);
        }
    }

}
