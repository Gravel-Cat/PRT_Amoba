package hu.nye.progtech.service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import hu.nye.progtech.domain.Game;
import hu.nye.progtech.domain.GameMap;
import hu.nye.progtech.domain.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileHandler.class);

    public static void saveFile(Game game) {
        try {
            Player player = game.getPlayer();
            GameMap gameMap = game.getGameMap();
            String playerName = player.getName();
            int playerWins = player.getWins();
            int mapSize = gameMap.getMapSize();
            char[][] moves = gameMap.getMoves();

            FileWriter file = new FileWriter("savefile.txt");
            file.write(playerName);
            file.write("\n" + playerWins);
            file.write("\n" + mapSize);
            for (int i = 0; i < mapSize; i++) {
                file.write("\n");
                for (int j = 0; j < mapSize; j++) {
                    file.write(moves[i][j]);
                }
            }
            file.close();
            LOGGER.info("\nSaved game to file!");

        } catch (IOException e) {
            LOGGER.error("A file error has occurred!");
            String error = Arrays.toString(e.getStackTrace());
            LOGGER.error(error);
        }
    }
}
