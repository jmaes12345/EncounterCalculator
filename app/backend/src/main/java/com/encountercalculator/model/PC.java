package com.encountercalculator.model;

import lombok.Getter;

@Getter
public class PC {
    private int level;

    public PC(int level) {
        if (!setLevel(level))
        {
            throw new IllegalArgumentException("Level " + level + " invalid. Please provide a value between 1 and 20.");
        }
    }

    public boolean setLevel(int level) {
        if (level > 0 && level < 21) {
            this.level = level;
            return true;
        } else {
            return false;
        }
    }
}
