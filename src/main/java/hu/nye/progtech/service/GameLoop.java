package hu.nye.progtech.service;

import java.util.Scanner;

import hu.nye.progtech.display.MapDisplayer;
import hu.nye.progtech.domain.Game;
import hu.nye.progtech.domain.GameMap;
import hu.nye.progtech.domain.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class GameLoop {
    private static final Logger LOGGER = LoggerFactory.getLogger(GameLoop.class);
    private final Scanner scanner;
    private final MapDisplayer mapDisplayer;

    public GameLoop(Scanner scanner, MapDisplayer mapDisplayer) {
        this.scanner = scanner;
        this.mapDisplayer = mapDisplayer;
    }

    public void gameMenu(Game game) {
        startGame(game);

        int valid = 0;
        while (valid != 1) {
            LOGGER.info("\nStart a new game? \n1- Yes \n2- No");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    gameMenu(game);
                    break;
                case 2:
                    valid = 1;
                    break;
                default:
                    valid = 0;
                    break;
            }
        }
    }

    public void startGame(Game game) {
        Player player = game.getPlayer();
        GameMap gameMap = game.getGameMap();
        char[][] moves = gameMap.getMoves();
        int mapSize = gameMap.getMapSize();

        mapDisplayer.displayMap(moves, mapSize);
        while (!GameState.isFinished(moves, mapSize, player)) {
            LOGGER.info("\n{}'s turn", player.getName());
            MoveHandler.readMove(moves, mapSize);
            LOGGER.info("\nBot's turn");
            MoveHandler.botMove(moves, mapSize);
            mapDisplayer.displayMap(moves, mapSize);
        }
        LOGGER.info("\nYour wins: {}", player.getWins());
    }
}
