package hu.nye.progtech.service;

import java.util.Scanner;

import hu.nye.progtech.domain.Game;
import hu.nye.progtech.domain.GameMap;
import hu.nye.progtech.domain.Player;
import hu.nye.progtech.init.MapInit;
import hu.nye.progtech.init.PlayerInit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InitDecider {
    private static final Logger LOGGER = LoggerFactory.getLogger(InitDecider.class);
    private final Scanner scanner;

    public InitDecider(final Scanner scanner) {
        this.scanner = scanner;
    }

    public Game getInitInstance(PlayerInit playerInit, MapInit mapInit) {
        LOGGER.info("\nPlease choose a game option: \n1- New Game \n2- Load Game");
        int instance = scanner.nextInt();
        switch (instance) {
            case 1:
                Player player = playerInit.readPlayerDetails();
                GameMap gameMap = mapInit.readMapDetails();
                return new Game(gameMap, player);
            case 2:
                return FileHandler.loadFile();
            default:
                getInitInstance(playerInit, mapInit);
        }
        return null;
    }
}
