package com.james.encountercalculator.model;

import java.util.ArrayList;
import java.util.List;

public class Party {
    private List<PC> pcList = new ArrayList<>();

    public Party(List<PC> pcs) {
        pcs.forEach(pc -> addPc(pc));
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

}
