package hu.nye.progtech.domain;

public final class GameMap {
    private final int mapSize;
    private final char[][] moves;

    public GameMap(int mapSize, char[][] moves) {
        this.mapSize = mapSize;
        this.moves = moves;
    }

    public int getMapSize() {
        return mapSize;
    }

    public char[][] getMoves() {
        return moves;
    }

    public char readMove(int row, int column) {
        return this.moves[row][column];
    }
}
