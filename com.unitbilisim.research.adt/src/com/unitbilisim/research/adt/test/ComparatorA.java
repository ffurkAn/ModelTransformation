package com.unitbilisim.research.adt.test;

import java.util.Comparator;

public class ComparatorA<T> implements Comparator<String> {

	@Override
	public int compare(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return arg0.compareTo(arg1);
	}

}
