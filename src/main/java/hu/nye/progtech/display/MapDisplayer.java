package hu.nye.progtech.display;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MapDisplayer {
    private static final Logger LOGGER = LoggerFactory.getLogger(MapDisplayer.class);

    public void displayMap(final char[][] moves, final int mapSize) {
        final StringBuilder map = new StringBuilder();
        map.append("\n   ");
        for (int i = 0; i < mapSize; i++) {
            map.append((char) ('a' + i)).append(" ");
        }

        map.append("\n  +");
        map.append("-".repeat(Math.max(0, (mapSize * 2) - 1)));
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
        map.append("-".repeat(Math.max(0, (mapSize * 2) - 1)));
        map.append("+");

        LOGGER.info("{}", map);
    }
}
