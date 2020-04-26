package com.james.encountercalculator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Party {
    private List<PC> pcList = new ArrayList<>();

    public Party(int[] pcs) {
        Arrays.stream(pcs).boxed().collect(Collectors.toList())
                .forEach(this::addPc);
    }

    public Party(List<Integer> pcs) {
        pcs.forEach(this::addPc);
    }

    public List<PC> getPcList() {
        return pcList;
    }

    public void setPcList(List<PC> pcList) {
        this.pcList = pcList;
    }

    public boolean addPc(PC pc) {
        return pcList.add(pc);
    }

    public boolean addPc(int pcLevel) {
        return pcList.add(
                new PC(pcLevel)
        );
    }
}
