package com.aurionpro.GuitarApp.Solution.FinalTest;

import java.util.List;

import com.aurionpro.GuitarApp.Solution.model.Guitar;
import com.aurionpro.GuitarApp.Solution.model.GuitarSpecs;
import com.aurionpro.GuitarApp.Solution.model.Inventory;

public class GuitarSearchService {
    private Inventory inventory;

    public GuitarSearchService(Inventory inventory) {
        this.inventory = inventory;
    }

    public List<Guitar> searchGuitars(GuitarSpecs specs) {
        return inventory.search(specs);
    }
}
