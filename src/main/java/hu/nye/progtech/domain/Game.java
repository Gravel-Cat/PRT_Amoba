package hu.nye.progtech.domain;

public final class Game {
    private final GameMap gameMap;
    private final Player player;

    public Game(GameMap gameMap, Player player) {
        this.gameMap = gameMap;
        this.player = player;
    }

    public GameMap getGameMap() {
        return gameMap;
    }

    public Player getPlayer() {
        return player;
    }
}
