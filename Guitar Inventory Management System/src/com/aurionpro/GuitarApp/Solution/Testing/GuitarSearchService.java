package com.aurionpro.GuitarApp.Solution.Testing;



import java.util.ArrayList;
import java.util.List;

import com.aurionpro.GuitarApp.Solution.model.Guitar;
import com.aurionpro.GuitarApp.Solution.model.GuitarSpecs;



public class GuitarSearchService {

	public static List<Guitar> search(GuitarSpecs filter, List<Guitar> inventoryGuitars) {
		List<Guitar> result = new ArrayList<>();

		for (Guitar guitar : inventoryGuitars) {
			GuitarSpecs spec = guitar.getSpecs();
			if (filter.getBuilder() != null && filter.getBuilder() != spec.getBuilder())
				continue;
			if (!filter.getModel().isEmpty() && !filter.getModel().equalsIgnoreCase(spec.getModel()))
				continue;
			if (filter.getType() != null && filter.getType() != spec.getType())
				continue;
			if (filter.getNumStrings() > 0 && filter.getNumStrings() != spec.getNumStrings())
				continue;
			if (filter.getBackwood() != null && filter.getBackwood() != spec.getBackwood())
				continue;
			if (filter.getTopwood() != null && filter.getTopwood() != spec.getTopwood())
				continue;

			result.add(guitar);
		}

		return result;
	}
}

