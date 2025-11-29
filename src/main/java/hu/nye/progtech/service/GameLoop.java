package hu.nye.progtech.service;

import java.util.Scanner;

import hu.nye.progtech.display.MapDisplayer;
import hu.nye.progtech.domain.Game;
import hu.nye.progtech.domain.GameMap;
import hu.nye.progtech.domain.Player;
import hu.nye.progtech.init.MapInit;
import hu.nye.progtech.init.NewMapInit;
import hu.nye.progtech.init.PlayerInit;
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

    public void gameMenu(InitDecider initDecider, PlayerInit playerInit) {
        MapInit mapInit = initDecider.getInitInstance();
        Player player = playerInit.readPlayerDetails();
        GameMap gameMap = mapInit.readMapDetails();
        startGame(new Game(gameMap, player));

        int valid = 0;
        while (valid != 1) {
            LOGGER.info("\nStart a new game? \n1- Yes \n2- No");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    mapInit = new NewMapInit(scanner);
                    gameMap = mapInit.readMapDetails();
                    startGame(new Game(gameMap, player));
                    break;
                case 2:
                    valid = 1;
                    break;
                default:
                    break;
            }
        }
    }

    public void startGame(Game game) {
        Player player = game.getPlayer();
        String playerName = player.getName();
        int playerWins = player.getWins();
        GameMap gameMap = game.getGameMap();
        char[][] moves = gameMap.getMoves();
        int mapSize = gameMap.getMapSize();

        boolean gameRunning = true;
        while (gameRunning) {
            mapDisplayer.displayMap(moves, mapSize);
            LOGGER.info("\n{}'s turn", playerName);
            int option = 0;
            while (option < 1 || option > 3) {
                LOGGER.info("\nChoose an option: \n1- Make a move \n2- Save game \n3- Quit game");
                option = scanner.nextInt();
            }
            switch (option) {
                case 1:
                    MoveHandler.readMove(moves, mapSize);
                    gameRunning = GameState.isRunning(moves, mapSize);
                    if (!gameRunning) {
                        mapDisplayer.displayMap(moves, mapSize);
                        player.setWins(player.getWins() + 1);
                        playerWins++;
                        LOGGER.info("\nYour wins: {}", playerWins);
                        break;
                    }
                    if (GameState.noMoreMoves(moves, mapSize)) {
                        break;
                    }
                    mapDisplayer.displayMap(moves, mapSize);
                    LOGGER.info("\nBot's turn");
                    MoveHandler.botMove(moves, mapSize);
                    break;
                case 2:
                    FileHandler.saveFile(game);
                    break;
                case 3:
                    gameRunning = false;
                    break;
                default:
                    break;
            }
        }
    }
}
