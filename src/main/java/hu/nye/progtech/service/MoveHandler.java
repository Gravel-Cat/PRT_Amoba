package hu.nye.progtech.service;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoveHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(MoveHandler.class);
    private static final Scanner scanner = new Scanner(System.in);

    public static void setMove(char[][] moves, char move, int row, int column) {
        moves[(row - 1)][(column - 1)] = move;
    }

    public static void readMove(char[][] moves, int mapSize) {
        int row;
        int column;

        LOGGER.info("Please enter your move's placement (row, column):");
        row = scanner.nextInt();
        column = scanner.next().charAt(0) - 96;

        boolean movePlaced = false;
        while (!(movePlaced)) {
            if (isIllegal(mapSize, row, column)) {
                LOGGER.info("Invalid move! (row, column):");
                row = scanner.nextInt();
                column = scanner.next().charAt(0) - 96;
                continue;
            } else if (isOccupied(moves, row, column)) {
                LOGGER.info("Already occupied! (row, column):");
                row = scanner.nextInt();
                column = scanner.next().charAt(0) - 96;
                continue;
            } else if (!(isConnected(moves, mapSize, row, column))) {
                LOGGER.info("Not connected! (row, column):");
                row = scanner.nextInt();
                column = scanner.next().charAt(0) - 96;
                continue;
            }
            movePlaced = true;
        }
        setMove(moves, 'x', row, column);
    }

    public static boolean isIllegal(int mapSize, int row, int column) {
        return row < 1 || row > mapSize || column < 1 || column > mapSize;
    }

    public static boolean isOccupied(char[][] moves, int row, int column) {
        return moves[row - 1][column - 1] != ' ';
    }

    public static boolean isConnected(char[][] moves, int mapSize, int row, int column) {
        // corner checks
        if (row == 1 && column == 1) {
            return moves[row - 1][column] != ' ' || moves[row][column - 1] != ' ' || moves[row][column] != ' ';
        }
        if (row == 1 && column == mapSize) {
            return moves[row - 1][column - 2] != ' ' || moves[row][column - 2] != ' ' || moves[row][column - 1] != ' ';
        }
        if (row == mapSize && column == 1) {
            return moves[row - 2][column - 1] != ' ' || moves[row - 2][column] != ' ' || moves[row - 1][column] != ' ';
        }
        if (row == mapSize && column == mapSize) {
            return moves[row - 2][column - 2] != ' ' || moves[row - 2][column - 1] != ' ' || moves[row - 1][column - 2] != ' ';
        }

        // side checks
        if (row == 1 && (column > 1 && column < mapSize)) {
            if (moves[row - 1][column - 2] != ' ' || moves [row - 1][column] != ' ') {
                return true;
            } else {
                for (int i = 2; i >= 0; i--) {
                    if (moves[row][column - i] != ' ') {
                        return true;
                    }
                }
            }
        }
        if (row == mapSize && (column > 1 && column < mapSize)) {
            if (moves[row - 1][column - 2] != ' ' || moves [row - 1][column] != ' ') {
                return true;
            } else {
                for (int i = 2; i >= 0; i--) {
                    if (moves[row - 2][column - i] != ' ') {
                        return true;
                    }
                }
            }
        }
        if (column == 1 && (row > 1 && row < mapSize)) {
            if (moves[row - 2][column - 1] != ' ' || moves [row][column - 1] != ' ') {
                return true;
            } else {
                for (int i = 2; i >= 0; i--) {
                    if (moves[row - i][column] != ' ') {
                        return true;
                    }
                }
            }
        }
        if (column == mapSize && (row > 1 && row < mapSize)) {
            if (moves[row - 2][column - 1] != ' ' || moves [row][column - 1] != ' ') {
                return true;
            } else {
                for (int i = 2; i >= 0; i--) {
                    if (moves[row - i][column - 2] != ' ') {
                        return true;
                    }
                }
            }
        }

        //middle check
        if ((row > 1 && row < mapSize) && (column > 1 && column < mapSize)) {
            for (int i = 2; i >= 0; i--) {
                if (moves[row - 2][column - i] != ' ') {
                    return true;
                }
                if (moves[row][column - i] != ' ') {
                    return true;
                }
            }
            return moves[row - 1][column - 2] != ' ' || moves[row - 1][column] != ' ';
        }
        return false;
    }
}
