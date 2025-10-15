package hu.nye.progtech.service;

public class MoveHandler {
    public static void setMove(char[][] moves, char move, int row, int column) {
        moves[(row - 1)][(column - 1)] = move;
    }
}
