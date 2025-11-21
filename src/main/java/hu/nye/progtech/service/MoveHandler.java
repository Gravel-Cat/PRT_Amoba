package hu.nye.progtech.service;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoveHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(MoveHandler.class);
    private static final Scanner scanner = new Scanner(System.in);

    public static void setMove(char[][] moves, char move, int row, int column) {
        moves[row][column] = move;
    }

    public static void readMove(char[][] moves, int mapSize) {
        int row;
        int column;

        LOGGER.info("Please enter your move's placement (row, column):");
        row = scanner.nextInt() - 1;
        column = scanner.next().charAt(0) - 97;

        boolean movePlaced = false;
        while (!movePlaced) {
            if (isIllegal(mapSize, row, column)) {
                LOGGER.info("Invalid move! (row, column):");
                row = scanner.nextInt() - 1;
                column = scanner.next().charAt(0) - 97;
                continue;
            } else if (isOccupied(moves, row, column)) {
                LOGGER.info("Already occupied! (row, column):");
                row = scanner.nextInt() - 1;
                column = scanner.next().charAt(0) - 97;
                continue;
            } else if (!isConnected(moves, row, column)) {
                LOGGER.info("Not connected! (row, column):");
                row = scanner.nextInt() - 1;
                column = scanner.next().charAt(0) - 97;
                continue;
            }
            movePlaced = true;
        }
        setMove(moves, 'x', row, column);
    }

    public static void botMove(char[][] moves, int mapSize) {
        int row = (int) (Math.random() * mapSize);
        int column = (int) (Math.random() * mapSize);

        boolean movePlaced = false;
        while (!movePlaced) {
            if (isIllegal(mapSize, row, column)) {
                row = (int) (Math.random() * mapSize);
                column = (int) (Math.random() * mapSize);
                continue;
            } else if (isOccupied(moves, row, column)) {
                row = (int) (Math.random() * mapSize);
                column = (int) (Math.random() * mapSize);
                continue;
            } else if (!isConnected(moves, row, column)) {
                row = (int) (Math.random() * mapSize);
                column = (int) (Math.random() * mapSize);
                continue;
            }
            movePlaced = true;
        }
        setMove(moves, 'o', row, column);
    }

    public static boolean isIllegal(int mapSize, int row, int column) {
        return row < 0 || row > mapSize - 1 || column < 0 || column > mapSize - 1;
    }

    public static boolean isOccupied(char[][] moves, int row, int column) {
        return moves[row][column] != ' ';
    }

    public static boolean isConnected(char[][] moves, int row, int column) {
        boolean connected = false;
        for (int j = -1; j <= 1; j++) {
            for (int i = -1; i <= 1; i++) {
                try {
                    if (moves[row + i][column + j] != ' ') {
                        connected = true;
                        break;
                    }
                } catch (Exception ignored) {
                    continue;
                }
            }
        }
        return connected;
    }
}
