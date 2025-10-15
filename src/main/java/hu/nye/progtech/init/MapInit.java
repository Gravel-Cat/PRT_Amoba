package hu.nye.progtech.init;

import hu.nye.progtech.domain.GameMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public final class MapInit {
    private static final Logger LOGGER = LoggerFactory.getLogger(MapInit.class);
    private final Scanner scanner;

    public MapInit(final Scanner scanner) {
        this.scanner = scanner;
    }

    public GameMap readMapDetails() {
        final int mapSize = getDetailsInInt("Please enter map size: ");
        final char[][] moves = new char[mapSize][mapSize];
        for(int i=0;i<mapSize;i++){
            for(int j=0;j<mapSize;j++){
                moves[i][j]=' ';
            }
        }
        return new GameMap(mapSize, moves);
    }

    private int getDetailsInInt(final String message){
        LOGGER.info(message);
        return scanner.nextInt();
    }
}
