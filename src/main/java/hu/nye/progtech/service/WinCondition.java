package hu.nye.progtech.service;

/*import org.slf4j.Logger;
import org.slf4j.LoggerFactory;*/

public class WinCondition {
    //private static final Logger LOGGER = LoggerFactory.getLogger(MoveHandler.class);

    public static boolean winCheck(char[][] moves, int mapSize, char move) {
        return horizontalCheck(moves, mapSize, move) ||
                verticalCheck(moves, mapSize, move) ||
                diagonalRightCheck(moves, mapSize, move) ||
                diagonalLeftCheck(moves, mapSize, move);
    }

    public static boolean horizontalCheck(char[][] moves, int mapSize, char move) {
        for (int i = 0; i < mapSize; i++) {
            int hits = 0;
            for (int j = 0; j < mapSize; j++) {
                if (moves[i][j] == move) {
                    hits++;
                } else {
                    hits = 0;
                }
                //LOGGER.info("i:{} j:{} hits:{}",i,j,hits);
                if (hits == 4) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean verticalCheck(char[][] moves, int mapSize, char move) {
        for (int i = 0; i < mapSize; i++) {
            int hits = 0;
            for (int j = 0; j < mapSize; j++) {
                if (moves[j][i] == move) {
                    hits++;
                } else {
                    hits = 0;
                }
                //LOGGER.info("i:{} j:{} hits:{}",i,j,hits);
                if (hits == 4) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean diagonalRightCheck(char[][] moves, int mapSize, char move) {
        for (int i = 0; i < mapSize - 3; i++) {
            for (int j = 0; j < mapSize - 3; j++) {
                int hits = 0;
                for (int step = 0; step < 4; step++) {
                    if (moves[i + step][j + step] == move) {
                        hits++;
                    } else {
                        hits = 0;
                    }
                    //LOGGER.info("i:{} j:{} hits:{}",i,j,hits);
                    if (hits == 4) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean diagonalLeftCheck(char[][] moves, int mapSize, char move) {
        for (int i = 0; i < mapSize - 3; i++) {
            for (int j = mapSize - 1; j > mapSize - (mapSize - 2); j--) {
                int hits = 0;
                for (int step = 0; step < 4; step++) {
                    if (moves[i + step][j - step] == move) {
                        hits++;
                    } else {
                        hits = 0;
                    }
                    //LOGGER.info("i:{} j:{} hits:{}",i,j,hits);
                    if (hits == 4) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}