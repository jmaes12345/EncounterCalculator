package com.encountercalculator.engine;

import com.encountercalculator.model.Difficulty;
import com.encountercalculator.model.PC;
import com.encountercalculator.model.PCParty;

import java.util.Map;
import java.util.TreeMap;

public class PCThresholdEngine {

    // Level, Easy, Medium, Hard, Deadly. DMG pg 82
    private final static int[][] levelDifficultyXPMaster = {
            {1, 25, 50, 75, 100},
            {2, 50, 100, 150, 200},
            {3, 75, 150, 225, 400},
            {4, 125, 250, 375, 500},
            {5, 250, 500, 750, 1100},
            {6, 300, 600, 900, 1400},
            {7, 350, 750, 1100, 1700},
            {8, 450, 900, 1400, 2100},
            {9, 550, 1100, 1600, 2400},
            {10, 600, 1200, 1900, 2800},
            {11, 800, 1600, 2400, 3600},
            {12, 1000, 2000, 3000, 4500},
            {13, 1100, 2200, 3400, 5100},
            {14, 1250, 2500, 3800, 5700},
            {15, 1400, 2800, 4300, 6400},
            {16, 1600, 3200, 4800, 7200},
            {17, 2000, 3900, 5900, 8800},
            {18, 2100, 4200, 6300, 9500},
            {19, 2400, 4900, 7300, 10900},
            {20, 2800, 5700, 8500, 12700}
    };

    public static Map<Difficulty, Integer> calculatePCThresholds(PCParty PCParty) {
        Map<Difficulty, Integer> overallThresholds = generateThresholdMap();

        for (PC pc : PCParty.getPcList()) {
            Map<Difficulty, Integer> pcLevelThresholds = getThresholdValueForLevel(pc.getLevel());
            for (Difficulty diff : Difficulty.values()) {
                if (!diff.equals(Difficulty.TOO_EASY) && !diff.equals(Difficulty.IMPOSSIBLE)) {
                    overallThresholds.replace(diff, overallThresholds.get(diff) + pcLevelThresholds.get(diff));
                }
            }
        }
        overallThresholds.replace(Difficulty.TOO_EASY, 0);
        overallThresholds.replace(Difficulty.IMPOSSIBLE, overallThresholds.get(Difficulty.DEADLY) * 2);

        return overallThresholds;
    }

    static Map<Difficulty, Integer> getThresholdValueForLevel(int level) {
        int[] levelValues = levelDifficultyXPMaster[level - 1];
        return new TreeMap<Difficulty, Integer>() {{
            put(Difficulty.EASY, levelValues[1]);
            put(Difficulty.MEDIUM, levelValues[2]);
            put(Difficulty.HARD, levelValues[3]);
            put(Difficulty.DEADLY, levelValues[4]);
        }};
    }

    static Map<Difficulty, Integer> generateThresholdMap(int tooEasy, int easy, int medium, int hard, int deadly, int impossible) {
        Map<Difficulty, Integer> map = new TreeMap<>();
        map.put(Difficulty.TOO_EASY, tooEasy);
        map.put(Difficulty.EASY, easy);
        map.put(Difficulty.MEDIUM, medium);
        map.put(Difficulty.HARD, hard);
        map.put(Difficulty.DEADLY, deadly);
        map.put(Difficulty.IMPOSSIBLE, impossible);
        return map;
    }

    static Map<Difficulty, Integer> generateThresholdMap() {
        return generateThresholdMap(0, 0, 0, 0, 0, 0);
    }
}
