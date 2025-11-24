package hu.nye.progtech.service;

import hu.nye.progtech.display.MapDisplayer;
import hu.nye.progtech.domain.Game;
import hu.nye.progtech.domain.GameMap;
import hu.nye.progtech.domain.Player;

public class GameLoop {
    private final MapDisplayer mapDisplayer;

    public GameLoop (MapDisplayer mapDisplayer) {
        this.mapDisplayer = mapDisplayer;
    }

    public void startGame(Game game) {
        Player player = game.getPlayer();
        GameMap gameMap = game.getGameMap();
        char[][] moves = gameMap.getMoves();
        int mapSize = gameMap.getMapSize();

        mapDisplayer.displayMap(moves, mapSize);
        while (!GameState.isFinished(moves, mapSize)) {
            MoveHandler.readMove(moves, mapSize);
            MoveHandler.botMove(moves, mapSize);
            mapDisplayer.displayMap(moves, mapSize);
        }
    }
}
