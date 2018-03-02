package com.creditSuisse.form;

import java.util.Comparator;

public class CreditSuisseFormComparator implements Comparator<CreditSuisseForm> {

	public CreditSuisseFormComparator() {
		
	}
	@Override
	public int compare(CreditSuisseForm o1, CreditSuisseForm o2) {
		return Comparator.comparing(CreditSuisseForm :: getId)
				.thenComparing(CreditSuisseForm :: getTimeStamp)
				.compare(o1, o2);
	}
}
