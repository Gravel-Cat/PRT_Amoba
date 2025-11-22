package hu.nye.progtech;

import java.util.Scanner;

import hu.nye.progtech.display.MapDisplayer;
import hu.nye.progtech.domain.GameMap;
import hu.nye.progtech.init.MapInit;
import hu.nye.progtech.service.MoveHandler;
import hu.nye.progtech.service.WinCondition;

public class MainApp {
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final MapInit mapInit = new MapInit(scanner);
        final GameMap gameMap = mapInit.readMapDetails();
        final MapDisplayer mapDisplayer = new MapDisplayer();

        boolean win = false;
        mapDisplayer.displayMap(gameMap.getMapSize(), gameMap.getMoves());
        while (!win) {
            MoveHandler.readMove(gameMap.getMoves(), gameMap.getMapSize());
            MoveHandler.botMove(gameMap.getMoves(), gameMap.getMapSize());
            mapDisplayer.displayMap(gameMap.getMapSize(), gameMap.getMoves());
            win = WinCondition.winCheck(gameMap.getMoves(), gameMap.getMapSize(), 'x');
        }
    }
}
