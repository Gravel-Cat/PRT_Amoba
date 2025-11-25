package hu.nye.progtech.service;

import hu.nye.progtech.domain.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GameState {
    private static final Logger LOGGER = LoggerFactory.getLogger(GameState.class);

    public static boolean isFinished(char[][] moves, int mapSize, Player player) {
        if (playerWon(moves, mapSize)) {
            LOGGER.info("\nCongrats, you won!");
            player.setWins(player.getWins() + 1);
            return true;
        }
        if (botWon(moves, mapSize)) {
            LOGGER.info("\nGame over, the bot won!");
            return true;
        }
        return false;
    }

    public static boolean playerWon(char[][] moves, int mapSize) {
        return WinCondition.winCheck(moves, mapSize, 'x');
    }

    public static boolean botWon(char[][] moves, int mapSize) {
        return WinCondition.winCheck(moves, mapSize, 'o');
    }
}
