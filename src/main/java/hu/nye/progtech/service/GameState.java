package hu.nye.progtech.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GameState {
    private static final Logger LOGGER = LoggerFactory.getLogger(GameState.class);

    public static boolean isRunning(char[][] moves, int mapSize) {
        if (playerWon(moves, mapSize)) {
            LOGGER.info("\nCongrats, you won!");
            return false;
        }
        if (botWon(moves, mapSize)) {
            LOGGER.info("\nGame over, the bot won!");
            return false;
        }
        return true;
    }

    public static boolean noMoreMoves(char[][] moves, int mapSize) {
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                if (moves[i][j] == ' ') {
                    return false;
                }
            }
        }
        LOGGER.info("\nGame over, no more moves!");
        return true;
    }

    public static boolean playerWon(char[][] moves, int mapSize) {
        return WinCondition.winCheck(moves, mapSize, 'x');
    }

    public static boolean botWon(char[][] moves, int mapSize) {
        return WinCondition.winCheck(moves, mapSize, 'o');
    }
}
