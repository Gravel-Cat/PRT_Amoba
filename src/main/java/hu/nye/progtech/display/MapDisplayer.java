package hu.nye.progtech.display;

import hu.nye.progtech.domain.GameMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MapDisplayer {
    private static final Logger LOGGER = LoggerFactory.getLogger(MapDisplayer.class);

    public void displayMap(final GameMap gameMap) {
        final int mapSize = gameMap.getMapSize();
        final char[][] moves = gameMap.getMoves();
        LOGGER.info(printMap(mapSize, moves));
    }

    public String printMap(final int mapSize, final char[][] moves) {
        final StringBuilder map = new StringBuilder();
        map.append("\n   ");
        for (int i = 0; i < mapSize; i++) {
            map.append((char) ('a' + i)).append(" ");
        }

        map.append("\n  +");
        for (int i = 0; i < (mapSize * 2) - 1; i++) {
            map.append("-");
        }
        map.append("+");

        for (int i = 0; i < mapSize; i++) {
            if (i + 1 < 10) {
                map.append("\n ");
            } else {
                map.append("\n");
            }
            map.append(i + 1).append("|").append(moves[i][0]);

            for (int j = 1; j < mapSize; j++) {
                map.append(" ").append(moves[i][j]);
            }
            map.append("|");
        }

        map.append("\n  +");
        for (int i = 0; i < (mapSize * 2) - 1; i++) {
            map.append("-");
        }
        map.append("+");

        return map.toString();
    }
}
