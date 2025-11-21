package hu.nye.progtech.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WinCondition {
    private static final Logger LOGGER = LoggerFactory.getLogger(MoveHandler.class);

    public static boolean horizontalCheck(char[][] moves, int mapSize, char move) {
        int hits = 0;
        for (int j = 0; j < mapSize - 3; j++) {
            hits = 0;
            for (int i = 0; i < mapSize - 3; i++) {
                if (moves[i][j] == move) {
                    hits++;
                } else {
                    hits = 0;
                }
                if (hits == 4) {
                    LOGGER.info("Találat!");
                    return true;
                }
            }
        }
        LOGGER.info("Nincs találat.");
        return false;
    }
}

// 0 1 2 3 4
// x x x x x