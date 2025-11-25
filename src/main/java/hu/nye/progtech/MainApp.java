package hu.nye.progtech;

import java.util.Scanner;

import hu.nye.progtech.display.MapDisplayer;
import hu.nye.progtech.domain.Game;
import hu.nye.progtech.domain.GameMap;
import hu.nye.progtech.domain.Player;
import hu.nye.progtech.init.MapInit;
import hu.nye.progtech.init.PlayerInit;
import hu.nye.progtech.service.GameLoop;
import hu.nye.progtech.service.InitDecider;

public class MainApp {
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final PlayerInit playerInit = new PlayerInit(scanner);
        final InitDecider initDecider = new InitDecider(scanner);
        final MapDisplayer mapDisplayer = new MapDisplayer();

        final MapInit mapInit = initDecider.getInitInstance();
        final Player player = playerInit.readPlayerDetails();
        final GameMap gameMap = mapInit.readMapDetails();

        final GameLoop gameLoop = new GameLoop(scanner, mapDisplayer);

        gameLoop.gameMenu(new Game(gameMap, player));
        scanner.close();
    }
}
