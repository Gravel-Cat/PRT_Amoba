package hu.nye.progtech;

import java.util.Scanner;

import hu.nye.progtech.display.MapDisplayer;
import hu.nye.progtech.domain.GameMap;
import hu.nye.progtech.init.MapInit;
import hu.nye.progtech.service.GameState;
import hu.nye.progtech.service.MoveHandler;

public class MainApp {
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final MapInit mapInit = new MapInit(scanner);
        final GameMap gameMap = mapInit.readMapDetails();
        final MapDisplayer mapDisplayer = new MapDisplayer();

        mapDisplayer.displayMap(gameMap.getMapSize(), gameMap.getMoves());
        while (!GameState.isFinished(gameMap.getMoves(), gameMap.getMapSize())) {
            MoveHandler.readMove(gameMap.getMoves(), gameMap.getMapSize());
            MoveHandler.botMove(gameMap.getMoves(), gameMap.getMapSize());
            mapDisplayer.displayMap(gameMap.getMapSize(), gameMap.getMoves());
        }
    }
}
