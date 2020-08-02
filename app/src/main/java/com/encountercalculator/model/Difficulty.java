package com.encountercalculator.model;

public enum Difficulty {
    TOO_EASY(1),
    EASY(2),
    MEDIUM(3),
    HARD(4),
    DEADLY(5),
    IMPOSSIBLE(6);

    private final int rank;

    Difficulty(int rank) {
        this.rank = rank;
    }

    int getRank() {
        return rank;
    }
}
