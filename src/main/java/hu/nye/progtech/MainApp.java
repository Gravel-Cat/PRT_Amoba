package hu.nye.progtech;

import java.util.Scanner;

import hu.nye.progtech.display.MapDisplayer;
import hu.nye.progtech.domain.GameMap;
import hu.nye.progtech.domain.Player;
import hu.nye.progtech.init.MapInit;
import hu.nye.progtech.init.PlayerInit;
import hu.nye.progtech.service.GameState;
import hu.nye.progtech.service.MoveHandler;

public class MainApp {
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final PlayerInit playerInit = new PlayerInit(scanner);
        final MapInit mapInit = new MapInit(scanner);
        final Player player = playerInit.readPlayerDetails();
        final GameMap gameMap = mapInit.readMapDetails();
        final MapDisplayer mapDisplayer = new MapDisplayer();

        char[][] moves = gameMap.getMoves();
        int mapSize = gameMap.getMapSize();
        mapDisplayer.displayMap(moves, mapSize);
        while (!GameState.isFinished(moves, mapSize)) {
            MoveHandler.readMove(moves, mapSize);
            MoveHandler.botMove(moves, mapSize);
            mapDisplayer.displayMap(moves, mapSize);
        }
        scanner.close();
    }
}
