package connect_four;

import java.awt.*;
import java.util.*;
import java.util.List;

public class ConnectFour {
    private static int width = 7;
    private static int height = 6;
    private static Piece[][] pieces = new Piece[width][height];
    private static Point lastMovePosition = new Point(-1, -1);
    private static String[] rows = {"A", "B", "C", "D", "E", "F", "G"};

    public static String whoIsWinner(List<String> piecesPositionList) {
        for (Piece[] piece : pieces) {
            Arrays.fill(piece, Piece.Empty);
        }

        for (String position : piecesPositionList) {
            parsePosition(position);
            Piece winner = checkForWin();
            if (winner != Piece.Empty) {
                return winner.toString();
            }
        }
        return "Draw";
    }

    private static void print() {
        for (Piece[] piece : pieces) {
            System.out.println(Arrays.toString(piece));
        }
        System.out.println();
    }

    private static Piece checkForWin() {
        int x = ((int) lastMovePosition.getX());
        int y = ((int) lastMovePosition.getY());
        Piece possibleWinner = pieces[x][y];

        //rows
        int rowCount = 0;
        for (int i = x - 3; i < x + 4; i++) {
            if (pieceIsEqualTo(i, y, possibleWinner)) {
                rowCount++;
                if (rowCount == 4) {
                    return possibleWinner;
                }
            } else {
                rowCount = 0;
            }
        }

        //columns
        int columnCount = 0;
        for (int i = y - 3; i < y + 4; i++) {
            if (pieceIsEqualTo(x, i, possibleWinner)) {
                columnCount++;
                if (columnCount == 4) {
                    return possibleWinner;
                }
            } else {
                columnCount = 0;
            }
        }

        int diagonalCount = 0;
        for (int i = x - 3, j = y - 3; i < x + 4 && j < y + 4; i++, j++) {
            if (pieceIsEqualTo(i, j, possibleWinner)) {
                diagonalCount++;
                if (diagonalCount == 4) {
                    return possibleWinner;
                }
            } else {
                diagonalCount = 0;
            }
        }

        int diagonalCount2 = 0;
        for (int i = x - 3, j = y + 3; i < x + 4 && j > y - 4; i++, j--) {
            if (pieceIsEqualTo(i, j, possibleWinner)) {
                diagonalCount2++;
                if (diagonalCount2 == 4) {
                    return possibleWinner;
                }
            } else {
                diagonalCount2 = 0;
            }
        }
        return Piece.Empty;
    }

    private static boolean pieceIsEqualTo(int x, int y, Piece possibleWinner) {
        return x >= 0 && y >= 0 && x < width && y < height && pieces[x][y] == possibleWinner;
    }

    private static void parsePosition(String position) {
        String[] split = position.split("_");
        int rowNum = split[0].charAt(0) - 'A';
        for (int i = 0; i < height; i++) {
            if (pieces[rowNum][i] == Piece.Empty) {
                lastMovePosition.setLocation(rowNum, i);
                pieces[rowNum][i] = parsePiece(split[1]);
                return;
            }
        }
    }

    private static Piece parsePiece(String piece) {
        switch (piece) {
            case "Yellow":
                return Piece.Yellow;
            case "Red":
                return Piece.Red;
            default:
                throw new NoSuchElementException();
        }
    }

    public enum Piece {
        Red, Yellow, Empty;
    }
}
