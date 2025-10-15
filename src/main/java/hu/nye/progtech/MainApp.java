package hu.nye.progtech;

import java.util.Scanner;

import hu.nye.progtech.display.MapDisplayer;
import hu.nye.progtech.domain.GameMap;
import hu.nye.progtech.init.MapInit;
import hu.nye.progtech.service.MoveHandler;

public class MainApp {
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final MapInit mapInit = new MapInit(scanner);
        final GameMap gameMap = mapInit.readMapDetails();
        final MapDisplayer mapDisplayer = new MapDisplayer();

        MoveHandler.setMove(gameMap.getMoves(), 'x', 5, 5);

        mapDisplayer.displayMap(gameMap);
    }
}
