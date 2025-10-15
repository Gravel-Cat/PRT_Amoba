package hu.nye.progtech;

import hu.nye.progtech.init.MapInit;
import hu.nye.progtech.domain.GameMap;

import java.util.Scanner;

import static java.lang.Math.round;

public class MainApp {
    public static void main(final String[] args){
        final Scanner scanner = new Scanner(System.in);
        final MapInit mapInit = new MapInit(scanner);
        final GameMap gameMap = mapInit.readMapDetails();

        System.out.print("   ");
        for(int i=0; i<gameMap.getMapSize(); i++){
            System.out.printf("%c ",97+i);
        }
        System.out.print("\n  +");
        for(int i=0; i<(gameMap.getMapSize()*2)-1; i++){
            System.out.print("-");
        }
        System.out.print("+");

        for(int i=1; i<=gameMap.getMapSize(); i++){
            System.out.printf("\n%2d|",i);
            for(int j=0; j<(gameMap.getMapSize()*2)-1; j++){
                System.out.print(" ");
            }
            System.out.print("|");
        }

        System.out.print("\n  +");
        for(int i=0; i<(gameMap.getMapSize()*2)-1; i++){
            System.out.print("-");
        }
        System.out.print("+");
    }
}
