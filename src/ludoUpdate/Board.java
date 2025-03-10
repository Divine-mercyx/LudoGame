package ludoUpdate;

import java.util.HashMap;

public class Board {
    private Square[][] squares;
    private HashMap<String, Square> startingSquare;

    public Board() {
        this.squares = new Square[15][15];
        this.startingSquare = new HashMap<>();
        initializeSquares();
    }

    private void initializeSquares() {
        for (int row = 0; row < this.squares.length; row++) {
            for (int col = 0; col < this.squares[row].length; col++) {
                this.squares[row][col] = new Square( new Position(row, col), false );
            }
        }
        String[] colors = {"red", "green", "blue", "yellow"};
        setStartingSquare(colors);
    }


    private void setStartingSquare(String[] colors) {
        int[][] startingBox = {{6, 1}, {1, 8}, {8, 13}, {13, 6}};
        for (int index = 0; index < colors.length; index++) {
            String color = colors[index];
            int[] position = startingBox[index];
            Square startSquare = getSquares()[position[0]][position[1]];
            startSquare.setSafe(true);
            this.startingSquare.put(color, startSquare);
        }
    }


    public Square getStartingSquare(Player player) {
        String colorKey = player.getColor().toLowerCase();
        if (!startingSquare.containsKey(colorKey)) {
            System.out.println("Error: No starting square found for color " + colorKey);
            return null;
        }
        return startingSquare.get(colorKey);
    }


    public Square[][] getSquares() {
        return this.squares;
    }

    public int[][] getSquareIndex(Square square) {
        for (int row = 0; row < this.squares.length; row++) {
            for (int col = 0; col < this.squares[row].length; col++) {
                if (this.squares[row][col].equals(square)) return new int[][]{{row, col}};
            }
        }
        return new int[][]{};
    }


    public Square getNextSquare(Square currentSquare, String color, int steps) {
        int row = currentSquare.getPosition().getRow();
        int col = currentSquare.getPosition().getCol();

        for (int i = 0; i < steps; i++) {
                if (row == 6 && col < 6) {
                    col++;
                    if (col == 6) {
                        row--;
                    }
                } else if (col == 6 && row > 0) {
                    row--;
                    if (row == 8) {
                        col--;
                    }
                }

                else if (row == 0 && col < 8) {
                    col++;
                } else if (col == 8 && row < 6) {
                    row++;
                    if (row == 6) {
                        col++;
                    }
                } else if (row == 6 && col < 14) {
                    col++;
                }

                else if (col == 14 && row < 8) {
                    row++;
                }

                else if (row == 8 && col > 8) {
                    col--;
                    if (col == 8) {
                        row++;
                    }
                }

                else if (col == 8 && row < 14) {
                    row++;
                }

                else if (row == 14 && col > 6) {
                    col--;
                }


                else if (row == 8 && col > 0) {
                    col--;
                }


                else if (col == 0 && row > 0) {
                    row--;
                }

                if (color.equals("red")) {
                    if (row == 7 && col < 6) {
                        col++;
                    }
                }

                if (color.equals("green")) {
                    if (col == 7 && row < 6) {
                        row++;
                    }
                }


//                if (color.equals("blue")) {
//                    if (row == 7 && col <= 13) {
//                        col--;
//                    }
//                }
//
//                if (color.equals("yellow")) {
//                    if (col == 7 && row <= 13) {
//                        row--;
//                    }
//                }


        }

        return getSquares()[row][col];
    }



}
