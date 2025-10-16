package hu.nye.progtech.init;

import java.util.Scanner;

import hu.nye.progtech.domain.GameMap;
import hu.nye.progtech.service.MoveHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class MapInit {
    private static final Logger LOGGER = LoggerFactory.getLogger(MapInit.class);
    private final Scanner scanner;

    public MapInit(final Scanner scanner) {
        this.scanner = scanner;
    }

    public GameMap readMapDetails() {
        int mapSize = getDetailsInInt("Please enter map size (5-25):");
        while (mapSize < 5 || mapSize > 25) {
            mapSize = getDetailsInInt("Invalid size! Please enter map size (5-25):");
        }

        final char[][] moves = new char[mapSize][mapSize];
        for (int i = 1; i <= mapSize; i++) {
            for (int j = 1; j <= mapSize; j++) {
                MoveHandler.setMove(moves, ' ', i, j);
            }
        }

        int middlePoint = Math.round((float) mapSize / 2);
        if (mapSize % 2 == 0) {
            MoveHandler.setMove(moves, 'x', middlePoint, middlePoint);
            MoveHandler.setMove(moves, 'o', middlePoint, middlePoint + 1);
            MoveHandler.setMove(moves, 'o', middlePoint + 1, middlePoint);
            MoveHandler.setMove(moves, 'x', middlePoint + 1, middlePoint + 1);
        } else {
            MoveHandler.setMove(moves, 'x', middlePoint, middlePoint);
        }

        return new GameMap(mapSize, moves);
    }

    private int getDetailsInInt(final String message) {
        LOGGER.info(message);
        return scanner.nextInt();
    }
}
