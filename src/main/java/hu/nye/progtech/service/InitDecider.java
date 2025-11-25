package hu.nye.progtech.service;

import java.util.Scanner;

import hu.nye.progtech.init.MapInit;
import hu.nye.progtech.init.NewMapInit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InitDecider {
    private static final Logger LOGGER = LoggerFactory.getLogger(InitDecider.class);
    private final Scanner scanner;

    public InitDecider(final Scanner scanner) {
        this.scanner = scanner;
    }

    public MapInit getInitInstance() {
        LOGGER.info("\nPlease choose a game option: \n1- New Game \n2- Load Game");
        int instance = scanner.nextInt();
        return switch (instance) {
            case 1 -> new NewMapInit(scanner);
            default -> getInitInstance();
        };
    }
}
