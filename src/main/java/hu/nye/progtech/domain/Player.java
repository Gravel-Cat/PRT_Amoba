package hu.nye.progtech.domain;

public final class Player {
    private String name;
    private int wins;

    public Player(final String name, final int wins) {
        this.name = name;
        this.wins = wins;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public String getName() {
        return name;
    }

    public int getWins() {
        return wins;
    }
}
