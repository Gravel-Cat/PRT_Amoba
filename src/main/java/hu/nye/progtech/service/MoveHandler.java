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
        while ((row < 1 || row > mapSize) || (column < 1 || column > mapSize)) {
            LOGGER.info("Invalid move! Please enter your move's placement (row, column):");
            row = scanner.nextInt();
            column = scanner.next().charAt(0) - 96;
        }
        setMove(moves, 'x', row, column);
    }
}
