package hu.nye.progtech;

import java.util.Scanner;

import hu.nye.progtech.display.MapDisplayer;
import hu.nye.progtech.init.PlayerInit;
import hu.nye.progtech.service.GameLoop;
import hu.nye.progtech.service.InitDecider;

public class MainApp {
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final PlayerInit playerInit = new PlayerInit(scanner);
        final InitDecider initDecider = new InitDecider(scanner);
        final MapDisplayer mapDisplayer = new MapDisplayer();

        final GameLoop gameLoop = new GameLoop(scanner, mapDisplayer);

        gameLoop.gameMenu(initDecider, playerInit);
        scanner.close();
    }
}
